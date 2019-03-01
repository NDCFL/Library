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

import top.cflwork.vo.BorrowVo;
import top.cflwork.service.BorrowService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 借阅记录管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-01 17:27:02
 */
 
@Controller
@RequestMapping("/borrow")
public class BorrowController {
	@Autowired
	private BorrowService borrowService;
	
	@GetMapping("borrowPage")
	@RequiresPermissions("borrow:borrowPage")
	public String Borrow(){
	    return "/borrow/borrow";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("borrow:list")
	public List<BorrowVo> list(BorrowVo borrowVo){
		//查询列表数据
		List<BorrowVo> borrowList = borrowService.list(borrowVo);
//		Long total = borrowService.count(borrowVo);
//		PageUtils pageUtils = new PageUtils(borrowList, total);
		return borrowList;
	}

	@GetMapping("/add")
	@RequiresPermissions("borrow:add")
	public String add(){
	    return "/borrow/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("borrow:edit")
	public String edit(@PathVariable("id") String id,Model model){
		BorrowVo borrow = borrowService.get(id);
		model.addAttribute("borrow", borrow);
	    return "/borrow/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("borrow:edit")
    @ResponseBody
    public BorrowVo edit(@PathVariable("id") String id){
			BorrowVo borrow = borrowService.get(id);
        return borrow;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("borrow:add")
	public R save( BorrowVo borrow){
		if(borrowService.save(borrow)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("borrow:update")
	public R update( BorrowVo borrow){
		borrowService.update(borrow);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("borrow:remove")
	public R remove( String id){
		if(borrowService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("borrow:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		borrowService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("borrow:batchSave")
    public R batchSave(List<BorrowVo> borrowList){
			borrowService.batchSave(borrowList);
        return R.ok("批量新增成功");
    }
}
