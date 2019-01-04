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

import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.vo.BookVo;
import top.cflwork.service.BookService;


/**
 * 图书表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-04 20:10:23
 */
 
@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("bookPage")
	@RequiresPermissions("book:book")
	public String Book(){
	    return "/book/book";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("book:book")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BookVo> bookList = bookService.list(query);
		int total = bookService.count(query);
		PageUtils pageUtils = new PageUtils(bookList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("book:add")
	public String add(){
	    return "/book/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("book:edit")
	public String edit(@PathVariable("id") Long id,Model model){
		BookVo book = bookService.get(id);
		model.addAttribute("book", book);
	    return "/book/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("book:add")
	public R save(BookVo book){
		if(bookService.save(book)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("book:update")
	public R update( BookVo book){
		bookService.update(book);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("book:remove")
	public R remove( Long id){
		if(bookService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("book:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		bookService.batchRemove(ids);
		return R.ok();
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("book:batchSave")
    public R batchSave(List<BookVo> bookList){
			bookService.batchSave(bookList);
        return R.ok();
    }
}
