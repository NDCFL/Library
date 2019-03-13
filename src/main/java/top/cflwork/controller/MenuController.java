package top.cflwork.controller;

import com.xiaoleilu.hutool.util.PageUtil;
import top.cflwork.common.annotation.Log;
import top.cflwork.config.Constant;
import top.cflwork.util.PageUtils;
import top.cflwork.util.R;
import top.cflwork.vo.MenuVo;
import top.cflwork.service.MenuService;
import top.cflwork.vo.Tree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.cflwork.vo.TreePageVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cflworks 275300091@qq.com
 */
@RequestMapping("/menu")
@Controller
public class MenuController extends BaseController {
	public String prefix = "menu";
	@Autowired
	public MenuService menuService;

	@RequiresPermissions("menu:menu")
	@GetMapping("/menuPage")
	public String menu(Model model) {
		return prefix+"/menu";
	}

	@RequiresPermissions("menu:menu")
	@RequestMapping("/list")
	@ResponseBody
	public TreePageVo<MenuVo> list(@RequestParam Map<String, Object> params) {
		Map<String,Object> map = new HashMap<>();
		params.put("sort","order_num");
		params.put("order","asc");
		List<MenuVo> menus = menuService.list(params);
        TreePageVo<MenuVo> treePageVo = new TreePageVo<>();
        treePageVo.setCode(0);
        treePageVo.setData(menus);
        treePageVo.setCount(20l);
        treePageVo.setMsg("查询成功");
		return treePageVo;
	}

	@Log("添加菜单")
	@RequiresPermissions("menu:add")
	@GetMapping("/add/{pId}")
	public String add(Model model, @PathVariable("pId") String pId) {
		model.addAttribute("pId", pId);
		if (pId.equals("0")) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		return prefix + "/add";
	}

	@Log("编辑菜单")
	@RequiresPermissions("menu:edit")
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		MenuVo mdo = menuService.get(id);
		String pId = mdo.getParentId();
		model.addAttribute("pId", pId);
		if (pId.equals("0")) {
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
	public R save(MenuVo menu) {
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
	public R update(MenuVo menu) {
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
	public R remove(String id) {
		if (menuService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<MenuVo> tree() {
		Tree<MenuVo>  tree = menuService.getTree();
		return tree;
	}

	@GetMapping("/tree/{roleId}")
	@ResponseBody
	public Tree<MenuVo> tree(@PathVariable("roleId") String roleId) {
		Tree<MenuVo> tree = menuService.getTree(roleId);
		return tree;
	}
}
