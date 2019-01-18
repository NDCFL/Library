package top.cflwork.controller;

import java.util.List;
import java.util.Map;

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

import top.cflwork.vo.BookTypeVo;
import top.cflwork.service.BookTypeService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 图书分类
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-15 18:01:18
 */
 
@Controller
@RequestMapping("/bookType")
public class BookTypeController {
	@Autowired
	private BookTypeService bookTypeService;
	
	@GetMapping("bookTypePage")
	@RequiresPermissions("bookType:bookTypePage")
	public String BookType(){
	    return "/bookType/bookType";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("bookType:list")
	public PageUtils list(BookTypeVo bookTypeVo){
		//查询列表数据
		List<BookTypeVo> bookTypeList = bookTypeService.list(bookTypeVo);
		Long total = bookTypeService.count(bookTypeVo);
		PageUtils pageUtils = new PageUtils(bookTypeList, total);
		return pageUtils;
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("bookType:edit")
    @ResponseBody
	public BookTypeVo edit(@PathVariable("id") String id){
		BookTypeVo bookType = bookTypeService.get(id);
	    return bookType;
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("bookType:add")
	public R save( BookTypeVo bookType){
		bookType.setParentId("0");
		bookType.setIsActive(0);
		if(bookTypeService.save(bookType)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("bookType:update")
	public R update( BookTypeVo bookType){
		bookTypeService.update(bookType);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("bookType:remove")
	public R remove( String id){
		if(bookTypeService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("bookType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		try{
			bookTypeService.batchRemove(ids);
			return R.ok("批量删除成功");
		}catch (Exception e){
			e.printStackTrace();
			return R.error("批量删除失败");
		}
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("bookType:batchSave")
    public R batchSave(List<BookTypeVo> bookTypeList){
			bookTypeService.batchSave(bookTypeList);
        return R.ok("批量新增成功");
    }
}
