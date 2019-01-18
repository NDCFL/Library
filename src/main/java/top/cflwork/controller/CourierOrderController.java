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

import top.cflwork.vo.CourierOrderVo;
import top.cflwork.service.CourierOrderService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 快递订单管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:13:02
 */
 
@Controller
@RequestMapping("/courierOrder")
public class CourierOrderController {
	@Autowired
	private CourierOrderService courierOrderService;
	
	@GetMapping("courierOrderPage")
	@RequiresPermissions("courierOrder:courierOrderPage")
	public String CourierOrder(){
	    return "/courierOrder/courierOrder";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("courierOrder:list")
	public PageUtils list(CourierOrderVo courierOrderVo){
		//查询列表数据
		List<CourierOrderVo> courierOrderList = courierOrderService.list(courierOrderVo);
		Long total = courierOrderService.count(courierOrderVo);
		PageUtils pageUtils = new PageUtils(courierOrderList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("courierOrder:add")
	public String add(){
	    return "/courierOrder/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("courierOrder:edit")
	public String edit(@PathVariable("id") String id,Model model){
		CourierOrderVo courierOrder = courierOrderService.get(id);
		model.addAttribute("courierOrder", courierOrder);
	    return "/courierOrder/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("courierOrder:edit")
    @ResponseBody
    public CourierOrderVo edit(@PathVariable("id") String id){
			CourierOrderVo courierOrder = courierOrderService.get(id);
        return courierOrder;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("courierOrder:add")
	public R save( CourierOrderVo courierOrder){
		if(courierOrderService.save(courierOrder)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("courierOrder:update")
	public R update( CourierOrderVo courierOrder){
		courierOrderService.update(courierOrder);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("courierOrder:remove")
	public R remove( String id){
		if(courierOrderService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("courierOrder:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		courierOrderService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("courierOrder:batchSave")
    public R batchSave(List<CourierOrderVo> courierOrderList){
			courierOrderService.batchSave(courierOrderList);
        return R.ok("批量新增成功");
    }
}
