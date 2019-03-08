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

import top.cflwork.vo.MetatableVo;
import top.cflwork.service.MetatableService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 图书书目信息表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-07 16:50:26
 */
 
@Controller
@RequestMapping("/metatable")
public class MetatableController {
	@Autowired
	private MetatableService metatableService;
	
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
}
