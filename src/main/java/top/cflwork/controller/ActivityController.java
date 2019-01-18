package top.cflwork.controller;

import java.util.List;
import java.util.Map;

import com.xiaoleilu.hutool.date.DateUtil;
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

import top.cflwork.vo.ActivityVo;
import top.cflwork.service.ActivityService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 活动管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-10 17:18:46
 */
 
@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("activityPage")
	@RequiresPermissions("activity:activityPage")
	public String Activity(){
	    return "/activity/activity";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("activity:list")
	public PageUtils list(ActivityVo activityVo){
		//查询列表数据
		List<ActivityVo> activityList = activityService.list(activityVo);
		Long total = activityService.count(activityVo);
		PageUtils pageUtils = new PageUtils(activityList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("activity:add")
	public String add(){

		return "/activity/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("activity:edit")
	public String edit(@PathVariable("id") String id,Model model){
		ActivityVo activity = activityService.get(id);
		activity.setTime(DateUtil.format(activity.getStartTime(),"yyyy-MM-dd HH:mm:ss")+" - "+DateUtil.format(activity.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		model.addAttribute("activity", activity);
	    return "/activity/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("activity:add")
	public R save( ActivityVo activity){
		activity.setStatus(0);
		if(activityService.save(activity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("activity:update")
	public R update( ActivityVo activity){
		activityService.update(activity);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("activity:remove")
	public R remove( String id){
		if(activityService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("activity:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		activityService.batchRemove(ids);
		return R.ok();
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("activity:batchSave")
    public R batchSave(List<ActivityVo> activityList){
			activityService.batchSave(activityList);
        return R.ok();
    }
}
