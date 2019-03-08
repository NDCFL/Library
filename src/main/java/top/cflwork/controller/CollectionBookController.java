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

import top.cflwork.vo.CollectionBookVo;
import top.cflwork.service.CollectionBookService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 图书书目信息
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-07 17:23:37
 */
 
@Controller
@RequestMapping("/collectionBook")
public class CollectionBookController {
	@Autowired
	private CollectionBookService collectionBookService;
	
	@GetMapping("collectionBookPage")
	@RequiresPermissions("collectionBook:collectionBookPage")
	public String CollectionBook(){
	    return "/collectionBook/collectionBook";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("collectionBook:list")
	public PageUtils list(CollectionBookVo collectionBookVo){
		//查询列表数据
		List<CollectionBookVo> collectionBookList = collectionBookService.list(collectionBookVo);
		Long total = collectionBookService.count(collectionBookVo);
		PageUtils pageUtils = new PageUtils(collectionBookList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("collectionBook:add")
	public String add(){
	    return "/collectionBook/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("collectionBook:edit")
	public String edit(@PathVariable("id") String id,Model model){
		CollectionBookVo collectionBook = collectionBookService.get(id);
		model.addAttribute("collectionBook", collectionBook);
	    return "/collectionBook/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("collectionBook:edit")
    @ResponseBody
    public CollectionBookVo edit(@PathVariable("id") String id){
			CollectionBookVo collectionBook = collectionBookService.get(id);
        return collectionBook;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("collectionBook:add")
	public R save( CollectionBookVo collectionBook){
		if(collectionBookService.save(collectionBook)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("collectionBook:update")
	public R update( CollectionBookVo collectionBook){
		collectionBookService.update(collectionBook);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("collectionBook:remove")
	public R remove( String id){
		if(collectionBookService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("collectionBook:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		collectionBookService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("collectionBook:batchSave")
    public R batchSave(List<CollectionBookVo> collectionBookList){
			collectionBookService.batchSave(collectionBookList);
        return R.ok("批量新增成功");
    }
}
