package top.cflwork.controller;

import top.cflwork.common.annotation.Log;
import top.cflwork.config.Constant;
import top.cflwork.util.R;
import top.cflwork.domain.MenuVo;
import top.cflwork.service.MenuService;
import top.cflwork.vo.Tree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author cflworks 275300091@qq.com
 */
@RequestMapping("/menu")
@Controller
public class MenuController extends BaseController {
	String prefix = "system/menu";
	@Autowired
	MenuService menuService;

	@RequiresPermissions("menu:menu")
	@GetMapping("/menuPage")
	String menu(Model model) {
		return prefix+"/menu";
	}

	@RequiresPermissions("menu:menu")
	@RequestMapping("/list")
	@ResponseBody
	List<MenuVo> list(@RequestParam Map<String, Object> params) {
		List<MenuVo> menus = menuService.list(params);
		return menus;
	}

	@Log("添加菜单")
	@RequiresPermissions("menu:add")
	@GetMapping("/add/{pId}")
	String add(Model model, @PathVariable("pId") Long pId) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		return prefix + "/add";
	}

	@Log("编辑菜单")
	@RequiresPermissions("menu:edit")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		MenuVo mdo = menuService.get(id);
		Long pId = mdo.getParentId();
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		model.addAttribute("menu", mdo);
		return prefix+"/edit";
	}

	@Log("保存菜单")
	@RequiresPermissions("menu:add")
	@PostMapping("/save")
	@ResponseBody
	R save(MenuVo menu) {
		if (menuService.save(menu) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("更新菜单")
	@RequiresPermissions("menu:edit")
	@PostMapping("/update")
	@ResponseBody
	R update(MenuVo menu) {
		if (menuService.update(menu) > 0) {
			return R.ok();
		} else {
			return R.error(1, "更新失败");
		}
	}

	@Log("删除菜单")
	@RequiresPermissions("menu:remove")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (menuService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}

	@GetMapping("/tree")
	@ResponseBody
	Tree<MenuVo> tree() {
		Tree<MenuVo>  tree = menuService.getTree();
		return tree;
	}

	@GetMapping("/tree/{roleId}")
	@ResponseBody
	Tree<MenuVo> tree(@PathVariable("roleId") Long roleId) {
		Tree<MenuVo> tree = menuService.getTree(roleId);
		return tree;
	}
}