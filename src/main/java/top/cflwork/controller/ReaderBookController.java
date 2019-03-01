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

import top.cflwork.vo.ReaderBookVo;
import top.cflwork.service.ReaderBookService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 城市书房
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:36:12
 */
 
@Controller
@RequestMapping("/readerBook")
public class ReaderBookController {
	@Autowired
	private ReaderBookService readerBookService;
	
	@GetMapping("readerBookPage")
	@RequiresPermissions("readerBook:readerBookPage")
	public String ReaderBook(){
	    return "/readerBook/readerBook";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("readerBook:list")
	public List<ReaderBookVo> list(ReaderBookVo readerBookVo){
		//查询列表数据
		List<ReaderBookVo> readerBookList = readerBookService.list(readerBookVo);
//		Long total = readerBookService.count(readerBookVo);
//		PageUtils pageUtils = new PageUtils(readerBookList, total);
		return readerBookList;
	}

	@GetMapping("/add")
	@RequiresPermissions("readerBook:add")
	public String add(){
	    return "/readerBook/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("readerBook:edit")
	public String edit(@PathVariable("id") String id,Model model){
		ReaderBookVo readerBook = readerBookService.get(id);
		model.addAttribute("readerBook", readerBook);
	    return "/readerBook/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("readerBook:edit")
    @ResponseBody
    public ReaderBookVo edit(@PathVariable("id") String id){
			ReaderBookVo readerBook = readerBookService.get(id);
        return readerBook;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("readerBook:add")
	public R save( ReaderBookVo readerBook){
		if(readerBookService.save(readerBook)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("readerBook:update")
	public R update( ReaderBookVo readerBook){
		readerBookService.update(readerBook);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("readerBook:remove")
	public R remove( String id){
		if(readerBookService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("readerBook:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		readerBookService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("readerBook:batchSave")
    public R batchSave(List<ReaderBookVo> readerBookList){
			readerBookService.batchSave(readerBookList);
        return R.ok("批量新增成功");
    }
}
