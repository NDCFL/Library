package top.cflwork.controller;

import top.cflwork.config.Constant;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.service.DictService;
import top.cflwork.vo.DictVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-29 18:28:07
 */

@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
	@Autowired
	private DictService dictService;

	@GetMapping("dictPage")
	@RequiresPermissions("dict:dictPage")
	public String dict() {
		return "/dict/dict";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("dict:list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<DictVo> dictList = dictService.list(query);
		Long total = dictService.count(query);
		PageUtils pageUtils = new PageUtils(dictList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("dict:add")
	public String add() {
		return "/dict/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("dict:edit")
	public String edit(@PathVariable("id") String id, Model model) {
		DictVo dict = dictService.get(id);
		model.addAttribute("dict", dict);
		return "/dict/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("dict:add")
	public R save(DictVo dict) {
		if (dictService.save(dict) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dict:edit")
	public R update(DictVo dict) {
		dictService.update(dict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("dict:remove")
	public R remove(String id) {
		if (dictService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("dict:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids) {
		dictService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/type")
	@ResponseBody
	public List<DictVo> listType() {
		return dictService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	@RequiresPermissions("dict:add")
	public String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "/dict/add";
	}

	@ResponseBody
	@GetMapping("/list/{type}")
	public List<DictVo> listByType(@PathVariable("type") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", type);
		List<DictVo> dictList = dictService.list(map);
		return dictList;
	}
}
