package top.cflwork.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.cflwork.config.Constant;
import top.cflwork.service.LibraryService;
import top.cflwork.util.R;
import top.cflwork.vo.LibraryVo;
import top.cflwork.vo.Tree;
import top.cflwork.vo.TreePageVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图书馆管理
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-27 14:40:36
 */

@Controller
@RequestMapping("/sysLibrary")
public class LibraryController extends BaseController {
	private String prefix = "library";
	@Autowired
	private LibraryService sysLibraryService;

	@GetMapping("/sysLibraryPage")
	@RequiresPermissions("sysLibrary:sysLibraryPage")
	public String library() {
		return prefix + "/library";
	}

	@ApiOperation(value="获取图书馆列表", notes="")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sysLibrary:sysLibraryPage")
	public TreePageVo<LibraryVo> list() {
		TreePageVo<LibraryVo> treePageVo = new TreePageVo<>();
		Map<String, Object> query = new HashMap<>(16);
		List<LibraryVo> sysLibraryList = sysLibraryService.list(query);
		treePageVo.setCode(0);
		treePageVo.setData(sysLibraryList);
		treePageVo.setCount(20l);
		treePageVo.setMsg("查询成功");
		return treePageVo;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("sysLibrary:add")
	public String add(@PathVariable("pId") String pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId.equals("0")) {
			model.addAttribute("pName", "总图书馆");
		} else {
			model.addAttribute("pName", sysLibraryService.get(pId).getName());
		}
		return  prefix + "/add";
	}

	@GetMapping("/edit/{libraryId}")
	@RequiresPermissions("sysLibrary:edit")
	public String edit(@PathVariable("libraryId") String libraryId, Model model) {
		LibraryVo sysLibrary = sysLibraryService.get(libraryId);
		model.addAttribute("sysLibrary", sysLibrary);
		if(Constant.DEPT_ROOT_ID.equals(sysLibrary.getParentId())) {
			model.addAttribute("parentLibraryName", "无");
		}else {
			LibraryVo parLibrary = sysLibraryService.get(sysLibrary.getParentId());
			model.addAttribute("parentLibraryName", parLibrary.getName());
		}
		return  prefix + "/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("sysLibrary:add")
	public R save(LibraryVo sysLibrary) {
		if (sysLibraryService.save(sysLibrary) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sysLibrary:edit")
	public R update(LibraryVo sysLibrary) {
		if (sysLibraryService.update(sysLibrary) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("sysLibrary:remove")
	public R remove(String libraryId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", libraryId);
		if(sysLibraryService.count(map)>0) {
			return R.error(1, "包含下级图书馆,不允许修改");
		}
		if(sysLibraryService.checkLibraryHasUser(libraryId)) {
			if (sysLibraryService.remove(libraryId) > 0) {
				return R.ok();
			}
		}else {
			return R.error(1, "图书馆包含用户,不允许修改");
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("sysLibrary:batchRemove")
	public R remove(@RequestParam("ids[]") String[] libraryIds) {
		sysLibraryService.batchRemove(libraryIds);
		return R.ok();
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<LibraryVo> tree() {
		Tree<LibraryVo> tree = new Tree<LibraryVo>();
		tree = sysLibraryService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	public String treeView() {
		return  prefix + "/libraryTree";
	}

}
