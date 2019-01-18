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

import top.cflwork.vo.SpaceVo;
import top.cflwork.service.SpaceService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 场地管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 14:58:55
 */
 
@Controller
@RequestMapping("/space")
public class SpaceController {
	@Autowired
	private SpaceService spaceService;
	
	@GetMapping("spacePage")
	@RequiresPermissions("space:spacePage")
	public String Space(){
	    return "/space/space";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("space:list")
	public PageUtils list(SpaceVo spaceVo){
		//查询列表数据
		List<SpaceVo> spaceList = spaceService.list(spaceVo);
		Long total = spaceService.count(spaceVo);
		PageUtils pageUtils = new PageUtils(spaceList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("space:add")
	public String add(){
	    return "/space/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("space:edit")
	public String edit(@PathVariable("id") String id,Model model){
		SpaceVo space = spaceService.get(id);
		model.addAttribute("space", space);
	    return "/space/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("space:edit")
    @ResponseBody
    public SpaceVo edit(@PathVariable("id") String id){
			SpaceVo space = spaceService.get(id);
        return space;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("space:add")
	public R save( SpaceVo space){
		space.setIsActive(0);
		if(spaceService.save(space)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("space:update")
	public R update( SpaceVo space){
		spaceService.update(space);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("space:remove")
	public R remove( String id){
		if(spaceService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("space:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		spaceService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("space:batchSave")
    public R batchSave(List<SpaceVo> spaceList){
			spaceService.batchSave(spaceList);
        return R.ok("批量新增成功");
    }
}
