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

import top.cflwork.vo.ElectronExpressVo;
import top.cflwork.service.ElectronExpressService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 电子书的传递
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 17:57:32
 */
 
@Controller
@RequestMapping("/electronExpress")
public class ElectronExpressController {
	@Autowired
	private ElectronExpressService electronExpressService;
	
	@GetMapping("electronExpressPage")
	@RequiresPermissions("electronExpress:electronExpressPage")
	public String ElectronExpress(){
	    return "/electronExpress/electronExpress";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("electronExpress:list")
	public PageUtils list(ElectronExpressVo electronExpressVo){
		//查询列表数据
		List<ElectronExpressVo> electronExpressList = electronExpressService.list(electronExpressVo);
		Long total = electronExpressService.count(electronExpressVo);
		PageUtils pageUtils = new PageUtils(electronExpressList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("electronExpress:add")
	public String add(){
	    return "/electronExpress/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("electronExpress:edit")
	public String edit(@PathVariable("id") String id,Model model){
		ElectronExpressVo electronExpress = electronExpressService.get(id);
		model.addAttribute("electronExpress", electronExpress);
	    return "/electronExpress/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("electronExpress:edit")
    @ResponseBody
    public ElectronExpressVo edit(@PathVariable("id") String id){
			ElectronExpressVo electronExpress = electronExpressService.get(id);
        return electronExpress;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("electronExpress:add")
	public R save( ElectronExpressVo electronExpress){
		if(electronExpressService.save(electronExpress)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("electronExpress:update")
	public R update( ElectronExpressVo electronExpress){
		electronExpressService.update(electronExpress);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("electronExpress:remove")
	public R remove( String id){
		if(electronExpressService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("electronExpress:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		electronExpressService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("electronExpress:batchSave")
    public R batchSave(List<ElectronExpressVo> electronExpressList){
			electronExpressService.batchSave(electronExpressList);
        return R.ok("批量新增成功");
    }
}
