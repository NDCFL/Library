package top.cflwork.controller;

import top.cflwork.common.annotation.Log;
import top.cflwork.config.Constant;
import top.cflwork.controller.BaseController;
import top.cflwork.util.R;
import top.cflwork.vo.RoleVo;
import top.cflwork.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController extends BaseController {
	String prefix = "role";
	@Autowired
	public RoleService roleService;

	@RequiresPermissions("role:role")
	@GetMapping("rolePage")
	public String role() {
		return prefix + "/role";
	}

	@RequiresPermissions("role:role")
	@GetMapping("/list")
	@ResponseBody()
	public List<RoleVo> list() {
		List<RoleVo> roles = roleService.list();
		return roles;
	}

	@Log("添加角色")
	@RequiresPermissions("role:add")
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	@Log("编辑角色")
	@RequiresPermissions("role:edit")
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		RoleVo roleVo = roleService.get(id);
		model.addAttribute("role", roleVo);
		return prefix + "/edit";
	}

	@Log("保存角色")
	@RequiresPermissions("role:add")
	@PostMapping("/save")
	@ResponseBody()
	public R save(RoleVo role) {
		if (roleService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("更新角色")
	@RequiresPermissions("role:edit")
	@PostMapping("/update")
	@ResponseBody()
	public R update(RoleVo role) {
		if (roleService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("删除角色")
	@RequiresPermissions("role:remove")
	@PostMapping("/remove")
	@ResponseBody()
	public R save(String id) {
		if (roleService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
	
	@RequiresPermissions("role:batchRemove")
	@Log("批量删除角色")
	@PostMapping("/batchRemove")
	@ResponseBody
	public R batchRemove(@RequestParam("ids[]") String[] ids) {
		int r = roleService.batchremove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
