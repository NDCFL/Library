package top.cflwork.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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

import top.cflwork.vo.NewBookVo;
import top.cflwork.service.NewBookService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-12 11:02:18
 */
 
@Controller
@RequestMapping("/newBook")
@Api(value = "/newBook",description = "新书通报")
public class NewBookController {
	@Autowired
	private NewBookService newBookService;
	
	@GetMapping("newBookPage")
	public String NewBook(){
	    return "/newBook/newBook";
	}

	@ResponseBody
	@PostMapping("/list")
	@ApiOperation("分页获取新书通报列表，也可以根据指定的参数搜索")
	public PageUtils list(@RequestBody @ApiParam("参数是个json对象，") NewBookVo newBookVo){
		//查询列表数据
		List<NewBookVo> newBookList = newBookService.list(newBookVo);
		Long total = newBookService.count(newBookVo);
		PageUtils pageUtils = new PageUtils(newBookList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	public String add(){
	    return "/newBook/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("newBook:edit")
	public String edit(@PathVariable("id") String id,Model model){
		NewBookVo newBook = newBookService.get(id);
		model.addAttribute("newBook", newBook);
	    return "/newBook/edit";
	}*/

    @GetMapping("/edit/{id}")
    @ResponseBody
    public NewBookVo edit(@PathVariable("id") String id){
			NewBookVo newBook = newBookService.get(id);
        return newBook;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( NewBookVo newBook){
		if(newBookService.save(newBook)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( NewBookVo newBook){
		newBookService.update(newBook);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( String id){
		if(newBookService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] ids){
		newBookService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    public R batchSave(List<NewBookVo> newBookList){
			newBookService.batchSave(newBookList);
        return R.ok("批量新增成功");
    }
}
