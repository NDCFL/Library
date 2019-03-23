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

import top.cflwork.vo.SpaceUseVo;
import top.cflwork.service.SpaceUseService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 预约场地管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 15:39:21
 */
 
@Controller
@RequestMapping("/spaceUse")
public class SpaceUseController extends BaseController{
	@Autowired
	private SpaceUseService spaceUseService;
	
	@GetMapping("spaceUsePage")
	@RequiresPermissions("spaceUse:spaceUsePage")
	public String SpaceUse(){
	    return "/spaceUse/spaceUse";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("spaceUse:list")
	public List<SpaceUseVo> list(SpaceUseVo spaceUseVo){
		//查询列表数据
		spaceUseVo.setLibraryId(getLibraryId());
		List<SpaceUseVo> spaceUseList = spaceUseService.list(spaceUseVo);
//		Long total = spaceUseService.count(spaceUseVo);
//		PageUtils pageUtils = new PageUtils(spaceUseList, total);
		return spaceUseList;
	}

	@GetMapping("/add")
	@RequiresPermissions("spaceUse:add")
	public String add(){
	    return "/spaceUse/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("spaceUse:edit")
	public String edit(@PathVariable("id") String id,Model model){
		SpaceUseVo spaceUse = spaceUseService.get(id);
		model.addAttribute("spaceUse", spaceUse);
	    return "/spaceUse/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("spaceUse:edit")
    @ResponseBody
    public SpaceUseVo edit(@PathVariable("id") String id){
			SpaceUseVo spaceUse = spaceUseService.get(id);
        return spaceUse;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("spaceUse:add")
	public R save( SpaceUseVo spaceUse){
		spaceUse.setLibraryId(getLibraryId());
		spaceUse.setStatus(3);
		if(spaceUseService.save(spaceUse)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("spaceUse:update")
	public R update( SpaceUseVo spaceUse){
		spaceUseService.update(spaceUse);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("spaceUse:remove")
	public R remove( String id){
		if(spaceUseService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("spaceUse:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		spaceUseService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("spaceUse:batchSave")
    public R batchSave(List<SpaceUseVo> spaceUseList){
			spaceUseService.batchSave(spaceUseList);
        return R.ok("批量新增成功");
    }
}
