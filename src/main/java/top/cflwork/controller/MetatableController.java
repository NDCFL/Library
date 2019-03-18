package top.cflwork.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.cflwork.common.Pager;
import top.cflwork.common.ResponseJson;
import top.cflwork.common.XmlSendUtil;
import top.cflwork.config.Constant;
import top.cflwork.service.NewBookService;
import top.cflwork.util.JaXmlBeanUtil;
import top.cflwork.vo.MetatableVo;
import top.cflwork.service.MetatableService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.vo.NewBookVo;
import top.cflwork.vo.SendVo;
import top.cflwork.vo.xmlvo.*;

/**
 * 图书书目信息表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-07 16:50:26
 */
 
@Controller
@RequestMapping("/metatable")
@Api(value = "/metatable",description = "图书书目信息模块")
public class MetatableController {
	@Autowired
	private MetatableService metatableService;
	@Autowired
	private NewBookService newBookService;
	@Autowired
	private XmlSendUtil xmlSendUtil;
	@GetMapping("metatablePage")
	@RequiresPermissions("metatable:metatablePage")
	public String Metatable(){
	    return "/metatable/metatable";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("metatable:list")
	public List<MetatableVo> list(MetatableVo metatableVo){
		//查询列表数据
		List<MetatableVo> metatableList = metatableService.list(metatableVo);
//		Long total = metatableService.count(metatableVo);
//		PageUtils pageUtils = new PageUtils(metatableList, total);
		return metatableList;
	}

	@GetMapping("/add")
	@RequiresPermissions("metatable:add")
	public String add(){
	    return "/metatable/add";
	}


    @GetMapping("/edit/{id}")
    @RequiresPermissions("metatable:edit")
    @ResponseBody
    public MetatableVo edit(@PathVariable("id") String id){
			MetatableVo metatable = metatableService.get(id);
        return metatable;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("metatable:add")
	public R save( MetatableVo metatable){
		if(metatableService.save(metatable)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("metatable:update")
	public R update( MetatableVo metatable){
		metatableService.update(metatable);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("metatable:remove")
	public R remove( String id){
		if(metatableService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("metatable:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		metatableService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("metatable:batchSave")
    public R batchSave(List<MetatableVo> metatableList){
			metatableService.batchSave(metatableList);
        return R.ok("批量新增成功");
    }

	/**
	 * 图书检索
	 */
	@PostMapping( "/bookSearch")
	@ResponseBody
	@ApiOperation(value = "all ,title,author,publisher,ctrlno,subject,isbn,callno,classno", notes = "搜索", response = BookSearchRootVo.class)
	public ResponseJson bookSearch(@ApiParam(value = "搜索图书的对象，只需要传递必填参数，搜索类型(searchType)，搜索内容(搜索内容)，当前页(pageNo)，页大小(pageSize)", required = true)@RequestBody BookSearchRootVo bookSearchRootVo){
		try{
			SendVo sendVo = new SendVo();
			sendVo.setWsUrl(Constant.BOOK.BOOKSEARCH);
			sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10018</eventType><pageNo>"+bookSearchRootVo.getPageNo()+"</pageNo><pageSize>"+bookSearchRootVo.getPageSize()+"</pageSize><select1>"+bookSearchRootVo.getSearchType()+"</select1><text1>"+bookSearchRootVo.getSearchValue()+"</text1><occur1/></text></root>");
			System.out.println(sendVo.getXmlParams()+"========================");
			ResponseJson responseJson  = xmlSendUtil.send(sendVo);
			System.out.println(responseJson+"==================");
			if(responseJson.getResult().isSuccess()){
				BookSearchRootVo bookSearchRootVo1 = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), BookSearchRootVo.class);
				//调用接口可以查询到
				if(bookSearchRootVo1.getCode()==0){
					//数据异常
					return new ResponseJson(false, "服务器接口异常");
				}else{
					//数据正常
					List<BookSearchVo> bookSearchVoList = bookSearchRootVo1.getText();
					metatableService.batchSaveBook(bookSearchVoList);
					return new ResponseJson(true,bookSearchRootVo1);
				}
			}else{
				return new ResponseJson(false, "服务器接口异常");
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseJson(false, "服务器接口异常");
		}
	}

	/**
	 * 图书书目信息详情
	 */
	@PostMapping( "/bookInfo")
	@ResponseBody
	@ApiOperation(value = "根据metaid,metable 两个参数，查询书目的详细信息", notes = "查询书目的详细信息", response = BookSearchRootVo.class)
	public ResponseJson bookInfo(@ApiParam(value = "根据metaid,metable 两个参数，查询书目的详细信息", required = true)@RequestBody MetatableVo metatableVo){
		try{
			SendVo sendVo = new SendVo();
			sendVo.setWsUrl(Constant.BOOK.BOOKINFO);
			sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10013</eventType><metaid>"+metatableVo.getMetaid()+"</metaid><metatable>"+metatableVo.getMetatable()+"</metatable></text></root>");
			System.out.println(sendVo.getXmlParams()+"========================");
			ResponseJson responseJson  = xmlSendUtil.send(sendVo);
			System.out.println(responseJson+"==================");
			if(responseJson.getResult().isSuccess()){
				MetaTableRootVo metaTableRootVo = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), MetaTableRootVo.class);
				//调用接口可以查询到
				if(metaTableRootVo.getCode()==0){
					//数据异常
					return new ResponseJson(false, "服务器接口异常");
				}else{
					//数据正常
					metaTableRootVo.getText().setMetaid(metatableVo.getMetaid());
					metaTableRootVo.getText().setMetatable(metatableVo.getMetatable());
					metatableService.updateBook(metaTableRootVo.getText());
					return new ResponseJson(true,metaTableRootVo);
				}
			}else{
				return new ResponseJson(false, "服务器接口异常");
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseJson(false, "服务器接口异常");
		}
	}
	/**
	 * 图书馆藏信息详情
	 */
	@PostMapping( "/bookList")
	@ResponseBody
	@ApiOperation(value = "根据metaid,metable 两个参数，查询图书馆藏信息详情", notes = "图书馆藏信息详情", response = BookSearchRootVo.class)
	public ResponseJson bookList(@ApiParam(value = "根据metaid,metable 两个参数，图书馆藏信息详情", required = true)@RequestBody CollectionBookRootVo collectionBookRootVo){
		try{
			SendVo sendVo = new SendVo();
			sendVo.setWsUrl(Constant.BOOK.BOOKLIST);
			sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10016</eventType><metaid>"+collectionBookRootVo.getMetaid()+"</metaid><metatable>"+collectionBookRootVo.getMetatable()+"</metatable><pageNo>"+collectionBookRootVo.getPageNo()+"</pageNo><pageSize>"+collectionBookRootVo.getPageSize()+"</pageSize></text></root>");
			System.out.println(sendVo.getXmlParams()+"========================");
			ResponseJson responseJson  = xmlSendUtil.send(sendVo);
			System.out.println(responseJson+"==================");
			if(responseJson.getResult().isSuccess()){
				CollectionBookRootVo collectionBookRootVo1 = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), CollectionBookRootVo.class);
				//调用接口可以查询到
				if(collectionBookRootVo1.getCode()==0){
					//数据异常
					return new ResponseJson(false, "服务器接口异常");
				}else{
					return new ResponseJson(true,collectionBookRootVo1);
				}
			}else{
				return new ResponseJson(false, "服务器接口异常");
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseJson(false, "服务器接口异常");
		}
	}

	/**
	 * 根据读者卡号，获取读者的借阅列表
	 */
	@PostMapping( "/bookBorrowByCard")
	@ResponseBody
	@ApiOperation(value = "根据cardno,读者卡号，获取读者的借阅列表", notes = "获取读者的借阅列表", response = BookSearchRootVo.class)
	public ResponseJson bookBorrowByCard(@ApiParam(value = "根据cardno,读者卡号，获取读者的借阅列表", required = true)@RequestBody BorrowsRootVo borrowsRootVo){
		try{
			SendVo sendVo = new SendVo();
			sendVo.setWsUrl(Constant.BOOK.BORROW);
			sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10015</eventType><cardno>"+borrowsRootVo.getCardno()+"</cardno></text></root>");
			System.out.println(sendVo.getXmlParams()+"========================");
			ResponseJson responseJson  = xmlSendUtil.send(sendVo);
			System.out.println(responseJson+"==================");
			if(responseJson.getResult().isSuccess()){
				BorrowsRootVo borrowsRootVo1 = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), BorrowsRootVo.class);
				//调用接口可以查询到
				if(borrowsRootVo1.getCode()==0){
					//数据异常
					return new ResponseJson(false, "服务器接口异常");
				}else{
					return new ResponseJson(true,borrowsRootVo1);
				}
			}else{
				return new ResponseJson(false, "服务器接口异常");
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseJson(false, "服务器接口异常");
		}
	}

	/**
	 * 根据读者证号查询读者历史流通记录
	 */
	@PostMapping( "/bookBorrowByCardList")
	@ResponseBody
	@ApiOperation(value = "根据cardno,读者卡号，根据读者证号查询读者历史流通记录", notes = "根据读者证号查询读者历史流通记录", response = BookSearchRootVo.class)
	public ResponseJson bookBorrowByCardList(@ApiParam(value = "根据cardno,读者卡号，根据读者证号查询读者历史流通记录", required = true)@RequestBody BorrowsRootVo borrowsRootVo){
		try{
			SendVo sendVo = new SendVo();
			sendVo.setWsUrl(Constant.BOOK.BORROW);
			sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10015</eventType><cardno>"+borrowsRootVo.getCardno()+"</cardno></text></root>");
			System.out.println(sendVo.getXmlParams()+"========================");
			ResponseJson responseJson  = xmlSendUtil.send(sendVo);
			System.out.println(responseJson+"==================");
			if(responseJson.getResult().isSuccess()){
				BorrowsRootVo borrowsRootVo1 = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), BorrowsRootVo.class);
				//调用接口可以查询到
				if(borrowsRootVo1.getCode()==0){
					//数据异常
					return new ResponseJson(false, "服务器接口异常");
				}else{
					return new ResponseJson(true,borrowsRootVo1);
				}
			}else{
				return new ResponseJson(false, "服务器接口异常");
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseJson(false, "服务器接口异常");
		}
	}

    /**
     * 新书通报
     */
    @PostMapping( "/newBookList")
    @ResponseBody
    @ApiOperation(value = "根据，分馆（sublib），起始时间（startDate），终止时间（endDate），当前页（pageNo），页大小（pageSize）", notes = "根据读者证号查询读者历史流通记录", response = BookSearchRootVo.class)
    public ResponseJson newBookList(@ApiParam(value = "根据cardno,读者卡号，根据读者证号查询读者历史流通记录", required = true)@RequestBody NewBookRootVo newBookRootVo){
        try{
            SendVo sendVo = new SendVo();
            sendVo.setWsUrl(Constant.BOOK.NEWBOOK);
            sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10003</eventType><startDate>"+newBookRootVo.getStartDate()+"</startDate><endDate>"+newBookRootVo.getEndDate()+"</endDate><sublib>QHL</sublib><pageNo>"+newBookRootVo.getPageNo()+"</pageNo><pageSize>"+newBookRootVo.getPageSize()+"</pageSize></text></root>");
            System.out.println(sendVo.getXmlParams()+"========================");
            ResponseJson responseJson  = xmlSendUtil.send(sendVo);
            System.out.println(responseJson+"==================");
            if(responseJson.getResult().isSuccess()){
                NewBookRootVo newBookRootVo1 = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), NewBookRootVo.class);
                //调用接口可以查询到
                if(newBookRootVo1.getCode()==0){
                    //数据异常
                    return new ResponseJson(false, "服务器接口异常");
                }else{
                	if(newBookRootVo1.getText()!=null){
						newBookService.bachSaveNewBook(newBookRootVo1.getText());
					}
                    return new ResponseJson(true,newBookRootVo1);
                }
            }else{
                return new ResponseJson(false, "服务器接口异常");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseJson(false, "服务器接口异常");
        }
    }
	@ResponseBody
	@PostMapping("/newBooklist")
	@ApiOperation("分页获取新书通报列表，也可以根据指定的参数搜索")
	public PageUtils list(@RequestBody @ApiParam("参数是个json对象，") NewBookVo newBookVo){
		//查询列表数据
		List<NewBookVo> newBookList = newBookService.list(newBookVo);
		Long total = newBookService.count(newBookVo);
		PageUtils pageUtils = new PageUtils(newBookList, total);
		return pageUtils;
	}

	public static void main(String[] args) {
		SendVo sendVo = new SendVo();
		sendVo.setWsUrl(Constant.BOOK.BOOKINFO);
		sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10013</eventType><metaid>66696</metaid><metatable>i_biblios</metatable></text></root>");
		ResponseJson responseJson  = new XmlSendUtil().send(sendVo);
		System.out.println(sendVo.getXmlParams());
		System.out.println(responseJson.getResult().getMsg()+"==================");
	}
}
