package top.cflwork.controller;

import top.cflwork.config.Constant;
import top.cflwork.controller.BaseController;
import top.cflwork.util.R;
import top.cflwork.vo.DeptVo;
import top.cflwork.service.DeptService;
import top.cflwork.vo.Tree;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-27 14:40:36
 */

@Controller
@RequestMapping("/sysDept")
public class DeptController extends BaseController {
	private String prefix = "dept";
	@Autowired
	private DeptService sysDeptService;

	@GetMapping("/sysDeptPage")
	@RequiresPermissions("sysDept:sysDeptPage")
	public String dept() {
		return prefix + "/dept";
	}

	@ApiOperation(value="获取部门列表", notes="")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sysDept:sysDeptPage")
	public List<DeptVo> list() {
		Map<String, Object> query = new HashMap<>(16);
		List<DeptVo> sysDeptList = sysDeptService.list(query);
		return sysDeptList;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("sysDept:add")
	public String add(@PathVariable("pId") Long pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "总部门");
		} else {
			model.addAttribute("pName", sysDeptService.get(pId).getName());
		}
		return  prefix + "/add";
	}

	@GetMapping("/edit/{deptId}")
	@RequiresPermissions("sysDept:edit")
	public String edit(@PathVariable("deptId") Long deptId, Model model) {
		DeptVo sysDept = sysDeptService.get(deptId);
		model.addAttribute("sysDept", sysDept);
		if(Constant.DEPT_ROOT_ID.equals(sysDept.getParentId())) {
			model.addAttribute("parentDeptName", "无");
		}else {
			DeptVo parDept = sysDeptService.get(sysDept.getParentId());
			model.addAttribute("parentDeptName", parDept.getName());
		}
		return  prefix + "/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("sysDept:add")
	public R save(DeptVo sysDept) {
		if (sysDeptService.save(sysDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sysDept:edit")
	public R update(DeptVo sysDept) {
		if (sysDeptService.update(sysDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("sysDept:remove")
	public R remove(Long deptId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", deptId);
		if(sysDeptService.count(map)>0) {
			return R.error(1, "包含下级部门,不允许修改");
		}
		if(sysDeptService.checkDeptHasUser(deptId)) {
			if (sysDeptService.remove(deptId) > 0) {
				return R.ok();
			}
		}else {
			return R.error(1, "部门包含用户,不允许修改");
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("sysDept:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] deptIds) {
		sysDeptService.batchRemove(deptIds);
		return R.ok();
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptVo> tree() {
		Tree<DeptVo> tree = new Tree<DeptVo>();
		tree = sysDeptService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	public String treeView() {
		return  prefix + "/deptTree";
	}

}
