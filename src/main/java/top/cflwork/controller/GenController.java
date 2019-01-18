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

import top.cflwork.vo.GenVo;
import top.cflwork.service.GenService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 情报管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 18:10:40
 */
 
@Controller
@RequestMapping("/gen")
public class GenController {
	@Autowired
	private GenService genService;
	
	@GetMapping("genPage")
	@RequiresPermissions("gen:genPage")
	public String Gen(){
	    return "/gen/gen";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("gen:list")
	public PageUtils list(GenVo genVo){
		//查询列表数据
		List<GenVo> genList = genService.list(genVo);
		Long total = genService.count(genVo);
		PageUtils pageUtils = new PageUtils(genList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("gen:add")
	public String add(){
	    return "/gen/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("gen:edit")
	public String edit(@PathVariable("id") String id,Model model){
		GenVo gen = genService.get(id);
		model.addAttribute("gen", gen);
	    return "/gen/edit";
	}*/

    @GetMapping("/edit/{id}")
    @RequiresPermissions("gen:edit")
    @ResponseBody
    public GenVo edit(@PathVariable("id") String id){
			GenVo gen = genService.get(id);
        return gen;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("gen:add")
	public R save( GenVo gen){
		gen.setStatus(3);
		if(genService.save(gen)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("gen:update")
	public R update( GenVo gen){
		genService.update(gen);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("gen:remove")
	public R remove( String id){
		if(genService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("gen:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		genService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("gen:batchSave")
    public R batchSave(List<GenVo> genList){
			genService.batchSave(genList);
        return R.ok("批量新增成功");
    }
}
