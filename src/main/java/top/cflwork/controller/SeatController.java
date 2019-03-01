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

import top.cflwork.vo.SeatVo;
import top.cflwork.service.SeatService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 座位管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 16:51:25
 */
 
@Controller
@RequestMapping("/seat")
public class SeatController {
	@Autowired
	private SeatService seatService;
	
	@GetMapping("seatPage")
	@RequiresPermissions("seat:seatPage")
	public String Seat(){
	    return "/seat/seat";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("seat:list")
	public List<SeatVo> list(SeatVo seatVo){
		//查询列表数据
		List<SeatVo> seatList = seatService.list(seatVo);
//		Long total = seatService.count(seatVo);
//		PageUtils pageUtils = new PageUtils(seatList, total);
		return seatList;
	}

	@GetMapping("/add")
	@RequiresPermissions("seat:add")
	public String add(){
	    return "/seat/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("seat:edit")
	public String edit(@PathVariable("id") String id,Model model){
		SeatVo seat = seatService.get(id);
		model.addAttribute("seat", seat);
	    return "/seat/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("seat:edit")
    @ResponseBody
    public SeatVo edit(@PathVariable("id") String id){
			SeatVo seat = seatService.get(id);
        return seat;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("seat:add")
	public R save( SeatVo seat){
		seat.setStatus("0");
		if(seatService.save(seat)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("seat:update")
	public R update( SeatVo seat){
		seatService.update(seat);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("seat:remove")
	public R remove( String id){
		if(seatService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("seat:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		seatService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("seat:batchSave")
    public R batchSave(List<SeatVo> seatList){
			seatService.batchSave(seatList);
        return R.ok("批量新增成功");
    }
}
