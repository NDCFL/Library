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

import top.cflwork.vo.IntegralTypeVo;
import top.cflwork.service.IntegralTypeService;
import top.cflwork.controller.BaseController;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 积分配置表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-23 16:17:48
 */
 
@Controller
@RequestMapping("/integralType")
public class IntegralTypeController extends BaseController{
	@Autowired
	private IntegralTypeService integralTypeService;
	
	@GetMapping("integralTypePage")
	@RequiresPermissions("integralType:integralTypePage")
	public String IntegralType(){
	    return "/integralType/integralType";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("integralType:list")
	public List<IntegralTypeVo> list(IntegralTypeVo integralTypeVo){
		//查询列表数据
			integralTypeVo.setLibraryId(getLibraryId());
		List<IntegralTypeVo> integralTypeList = integralTypeService.list(integralTypeVo);
//		Long total = integralTypeService.count(integralTypeVo);
//		PageUtils pageUtils = new PageUtils(integralTypeList, total);
		return integralTypeList;
	}

    @ResponseBody
    @PostMapping("/listAll")
    @RequiresPermissions("integralType:list")
    public List<IntegralTypeVo> listAll(IntegralTypeVo integralTypeVo){
        //查询列表数据
        List<IntegralTypeVo> integralTypeList = integralTypeService.list(integralTypeVo);
        return integralTypeList;
    }

	@GetMapping("/add")
	@RequiresPermissions("integralType:add")
	public String add(){
	    return "/integralType/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("integralType:edit")
	public String edit(@PathVariable("id") String id,Model model){
		IntegralTypeVo integralType = integralTypeService.get(id);
		model.addAttribute("integralType", integralType);
	    return "/integralType/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("integralType:edit")
    @ResponseBody
    public IntegralTypeVo edit(@PathVariable("id") String id){
			IntegralTypeVo integralType = integralTypeService.get(id);
        return integralType;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("integralType:add")
	public R save( IntegralTypeVo integralType){
			integralType.setLibraryId(getLibraryId());
		if(integralTypeService.save(integralType)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("integralType:update")
	public R update( IntegralTypeVo integralType){
		integralTypeService.update(integralType);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("integralType:remove")
	public R remove( String id){
		if(integralTypeService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("integralType:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		integralTypeService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("integralType:batchSave")
    public R batchSave(List<IntegralTypeVo> integralTypeList){
			integralTypeService.batchSave(integralTypeList);
        return R.ok("批量新增成功");
    }
}
