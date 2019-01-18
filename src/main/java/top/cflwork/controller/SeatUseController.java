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

import top.cflwork.vo.SeatUseVo;
import top.cflwork.service.SeatUseService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 座位预约管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:17:17
 */
 
@Controller
@RequestMapping("/seatUse")
public class SeatUseController {
	@Autowired
	private SeatUseService seatUseService;
	
	@GetMapping("seatUsePage")
	@RequiresPermissions("seatUse:seatUsePage")
	public String SeatUse(){
	    return "/seatUse/seatUse";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("seatUse:list")
	public PageUtils list(SeatUseVo seatUseVo){
		//查询列表数据
		List<SeatUseVo> seatUseList = seatUseService.list(seatUseVo);
		Long total = seatUseService.count(seatUseVo);
		PageUtils pageUtils = new PageUtils(seatUseList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("seatUse:add")
	public String add(){
	    return "/seatUse/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("seatUse:edit")
	public String edit(@PathVariable("id") String id,Model model){
		SeatUseVo seatUse = seatUseService.get(id);
		model.addAttribute("seatUse", seatUse);
	    return "/seatUse/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("seatUse:edit")
    @ResponseBody
    public SeatUseVo edit(@PathVariable("id") String id){
			SeatUseVo seatUse = seatUseService.get(id);
        return seatUse;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("seatUse:add")
	public R save( SeatUseVo seatUse){
		if(seatUseService.save(seatUse)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("seatUse:update")
	public R update( SeatUseVo seatUse){
		seatUseService.update(seatUse);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("seatUse:remove")
	public R remove( String id){
		if(seatUseService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("seatUse:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		seatUseService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("seatUse:batchSave")
    public R batchSave(List<SeatUseVo> seatUseList){
			seatUseService.batchSave(seatUseList);
        return R.ok("批量新增成功");
    }
}
