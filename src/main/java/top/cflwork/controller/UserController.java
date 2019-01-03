package top.cflwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import top.cflwork.common.annotation.Log;
import top.cflwork.config.Constant;
import top.cflwork.service.FileService;
import top.cflwork.util.*;
import top.cflwork.domain.DeptVo;
import top.cflwork.domain.RoleVo;
import top.cflwork.domain.UserVo;
import top.cflwork.service.DictService;
import top.cflwork.service.RoleService;
import top.cflwork.service.UserService;
import top.cflwork.vo.FileListVo;
import top.cflwork.vo.FileVo;
import top.cflwork.vo.Tree;
import top.cflwork.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
@Api(value = "/user",description = "用户模块")
public class UserController extends BaseController {
	private String prefix="system/user"  ;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	DictService dictService;
	@Autowired
	private FileService fileService;
//	@RequiresPermissions("user:userPage")
	@GetMapping("/userPage")
	String user() {
		return prefix + "/user";
	}

	@GetMapping("/list")
	@ResponseBody
	@ApiOperation(value="获取用户列表", notes="")
	PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<UserVo> sysUserList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("user:add")
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		List<RoleVo> roles = roleService.list();
		model.addAttribute("roles", roles);
		return prefix + "/add";
	}

	@RequiresPermissions("user:edit")
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		UserVo userDO = userService.get(id);
		model.addAttribute("user", userDO);
		List<RoleVo> roles = roleService.list(id);
		model.addAttribute("roles", roles);
		return prefix+"/edit";
	}

	@RequiresPermissions("user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
	R save(UserVo user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("user:edit")
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	R update(UserVo user) {
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("user:edit")
	@Log("更新用户")
	@PostMapping("/updatePeronal")
	@ResponseBody
	R updatePeronal(UserVo user) {
		if (userService.updatePersonal(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("user:remove")
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (userService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("user:batchRemove")
	@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		int r = userService.batchremove(userIds);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !userService.exit(params);
	}

	@RequiresPermissions("user:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {

		UserVo userDO = new UserVo();
		userDO.setUserId(userId);
		model.addAttribute("user", userDO);
		return prefix + "/reset_pwd";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(UserVO userVO) {
		try{
			userService.resetPwd(userVO,getUser());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@RequiresPermissions("user:resetPwd")
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(UserVO userVO) {
		try{
			userService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptVo> tree() {
		Tree<DeptVo> tree = new Tree<DeptVo>();
		tree = userService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	@GetMapping("/personal")
	String personal(Model model) {
		UserVo userDO  = userService.get(getUserId());
		model.addAttribute("user",userDO);
		model.addAttribute("hobbyList",dictService.getHobbyList(userDO));
		model.addAttribute("sexList",dictService.getSexList());
		return prefix + "/personal";
	}
	@ResponseBody
	@PostMapping("/uploadImg")
	R uploadImg(@RequestParam("avatar_file") MultipartFile file, String avatar_data, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		try {
			result = userService.updatePersonalImg(file, avatar_data, getUserId());
		} catch (Exception e) {
			return R.error("更新图像失败！");
		}
		if(result!=null && result.size()>0){
			return R.ok(result);
		}else {
			return R.error("更新图像失败！");
		}
	}
	@ResponseBody
	@PostMapping("/updateHeadIcon")
	public FileVo updateImg(MultipartFile file, HttpServletRequest request) {
		FileVo fileVo = new FileVo();
		try{
			UserVo userDO = userService.get(getUserId());
			String url = QiniuUtil.uploadImage(file, "upload/faceImg");
			Map<String,String> data = new HashMap<String, String>();
			data.put("src",url);
			fileVo.setData(data);
			System.out.println("保存到数据库的图片地址:"+url);
			fileVo.setCode(0);
			//如果修改了头像择删除原来的头像
			QiniuUtil.deleteFile(userDO.getHeadIcon());
			userDO.setHeadIcon(url);
			userService.update(userDO);//保存头像
		}catch (Exception e){
			e.printStackTrace();
			fileVo.setCode(1);
		}
		fileVo.setMsg("上传成功!");
		return  fileVo;
	}
	@ResponseBody
	@GetMapping("/getInfo")
	public R getInfo() {
		return  R.ok(Constant.PATH+userService.get(getUserId()).getHeadIcon());
	}
}