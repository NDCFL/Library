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

import top.cflwork.vo.PaperExpressVo;
import top.cflwork.service.PaperExpressService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 纸质书的传递
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:34:56
 */
 
@Controller
@RequestMapping("/paperExpress")
public class PaperExpressController extends BaseController{
	@Autowired
	private PaperExpressService paperExpressService;
	
	@GetMapping("paperExpressPage")
	@RequiresPermissions("paperExpress:paperExpressPage")
	public String PaperExpress(){
	    return "/paperExpress/paperExpress";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("paperExpress:list")
	public PageUtils list(PaperExpressVo paperExpressVo){
		//查询列表数据
		paperExpressVo.setLibraryId(getLibraryId());
		List<PaperExpressVo> paperExpressList = paperExpressService.list(paperExpressVo);
		Long total = paperExpressService.count(paperExpressVo);
		PageUtils pageUtils = new PageUtils(paperExpressList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("paperExpress:add")
	public String add(){
	    return "/paperExpress/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("paperExpress:edit")
	public String edit(@PathVariable("id") String id,Model model){
		PaperExpressVo paperExpress = paperExpressService.get(id);
		model.addAttribute("paperExpress", paperExpress);
	    return "/paperExpress/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("paperExpress:edit")
    @ResponseBody
    public PaperExpressVo edit(@PathVariable("id") String id){
			PaperExpressVo paperExpress = paperExpressService.get(id);
        return paperExpress;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("paperExpress:add")
	public R save( PaperExpressVo paperExpress){
		paperExpress.setLibraryId(getLibraryId());
		if(paperExpressService.save(paperExpress)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("paperExpress:update")
	public R update( PaperExpressVo paperExpress){
		paperExpressService.update(paperExpress);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("paperExpress:remove")
	public R remove( String id){
		if(paperExpressService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("paperExpress:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		paperExpressService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("paperExpress:batchSave")
    public R batchSave(List<PaperExpressVo> paperExpressList){
    	paperExpressList.stream().forEach(e->{
    		e.setLibraryId(getLibraryId());
		});
    	paperExpressService.batchSave(paperExpressList);
        return R.ok("批量新增成功");
    }
}
