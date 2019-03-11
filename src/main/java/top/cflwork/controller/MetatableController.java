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
import top.cflwork.util.JaXmlBeanUtil;
import top.cflwork.vo.MetatableVo;
import top.cflwork.service.MetatableService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.vo.SendVo;
import top.cflwork.vo.xmlvo.BookSearchRootVo;
import top.cflwork.vo.xmlvo.BookSearchVo;

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
	private XmlSendUtil xmlSendUtil;
	@GetMapping("metatablePage")
	@RequiresPermissions("metatable:metatablePage")
	public String Metatable(){
	    return "/metatable/metatable";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("metatable:list")
	public PageUtils list(MetatableVo metatableVo){
		//查询列表数据
		List<MetatableVo> metatableList = metatableService.list(metatableVo);
		Long total = metatableService.count(metatableVo);
		PageUtils pageUtils = new PageUtils(metatableList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("metatable:add")
	public String add(){
	    return "/metatable/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("metatable:edit")
	public String edit(@PathVariable("id") String id,Model model){
		MetatableVo metatable = metatableService.get(id);
		model.addAttribute("metatable", metatable);
	    return "/metatable/edit";
	}*/

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
	@RequestMapping("/update")
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
					bookSearchVoList.stream().forEach(e->{
						BookSearchVo bookSearchVo= new BookSearchVo();
						bookSearchVo.setMetaid(e.getMetaid()) ;
						bookSearchVo.setMetatable(e.getMetatable());
						MetatableVo metatableVo = new MetatableVo();
						metatableVo.setMetaid(e.getMetaid());
						metatableVo.setMetatable(e.getMetatable());
						long cnt = metatableService.count(metatableVo);
						if(cnt==0){
							metatableService.batchSaveBook(bookSearchVo);
						}
					});
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

	public static void main(String[] args) {
		SendVo sendVo = new SendVo();
		sendVo.setWsUrl(Constant.BOOK.BOOKSEARCH);
		sendVo.setXmlParams(Constant.XMLPARAMS+"<text>" +
				"<eventType>10018</eventType>\n" +
				"    <pageNo>1</pageNo>\n" +
				"    <pageSize>20</pageSize>\n" +
				"    <select1>all</select1>\n" +
				"    <text1>经济管理</text1>\n" +
				"<occur1/>" +
				"</text></root>");
		ResponseJson responseJson  = new XmlSendUtil().send(sendVo);
		System.out.println(sendVo.getXmlParams());
		System.out.println(responseJson.getResult().getMsg()+"==================");
	}
}
