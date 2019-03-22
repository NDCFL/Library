package top.cflwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.cflwork.common.annotation.Log;
import top.cflwork.config.Constant;
import top.cflwork.service.FileService;
import top.cflwork.util.*;
import top.cflwork.vo.DeptVo;
import top.cflwork.vo.RoleVo;
import top.cflwork.vo.UserVo;
import top.cflwork.service.DictService;
import top.cflwork.service.RoleService;
import top.cflwork.service.UserService;
import top.cflwork.vo.FileVo;
import top.cflwork.vo.Tree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.cflwork.vo.UserPwdVo;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
@Api(value = "/user",description = "用户模块")
public class UserController extends BaseController {
	private String prefix="user"  ;
	@Autowired
	public UserService userService;
	@Autowired
	public RoleService roleService;
	@Autowired
	public DictService dictService;
	@Autowired
	private FileService fileService;
//	@RequiresPermissions("user:userPage")
	@GetMapping("/userPage")
	public String user() {
		return prefix + "/user";
	}

	@GetMapping("/list")
	@ResponseBody
	@ApiOperation(value="获取用户列表", notes="")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		params.put("libraryId",getUser().getLibraryId());
		Query query = new Query(params);
		List<UserVo> sysUserList = userService.list(query);
		Long total = userService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("user:add")
	@Log("添加用户")
	@GetMapping("/add")
	public String add(Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("libraryId",getLibraryId());
		List<RoleVo> roles = roleService.list(map);
		model.addAttribute("roles", roles);
		return prefix + "/add";
	}

	@RequiresPermissions("user:edit")
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		UserVo userVo = userService.get(id);
		model.addAttribute("user", userVo);
		Map<String,Object> map = new HashMap<>();
		map.put("libraryId",getLibraryId());
		List<RoleVo> roles = roleService.list(map);
		model.addAttribute("roles", roles);
		return prefix+"/edit";
	}

	@RequiresPermissions("user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
	public R save(UserVo user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		user.setLibraryId(getLibraryId());
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("user:edit")
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	public R update(UserVo user) {
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("user:edit")
	@Log("更新用户")
	@PostMapping("/updatePeronal")
	@ResponseBody
	public R updatePeronal(UserVo user) {
		if (userService.updatePersonal(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("user:remove")
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	public R remove(String id) {
		if (userService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("user:batchRemove")
	@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	public R batchRemove(@RequestParam("ids[]") String[] userIds) {
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
	public String resetPwd(@PathVariable("id") String userId, Model model) {

		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		model.addAttribute("user", userVo);
		return prefix + "/reset_pwd";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	public R resetPwd(UserPwdVo userVo) {
		try{
			userService.resetPwd(userVo,getUser());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@RequiresPermissions("user:resetPwd")
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	public R adminResetPwd(UserPwdVo userPwdVo) {
		try{
			userService.adminResetPwd(userPwdVo);
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
	public String treeView() {
		return  prefix + "/userTree";
	}

	@GetMapping("/personal")
	public String personal(Model model) {
		UserVo userVo  = userService.get(getUserId());
		model.addAttribute("user",userVo);
		model.addAttribute("hobbyList",dictService.getHobbyList(userVo));
		model.addAttribute("sexList",dictService.getSexList());
		return prefix + "/personal";
	}
	@ResponseBody
	@PostMapping("/uploadImg")
	public R uploadImg(String base64) {
		try {
			String url = Base64ToImage.imgUpload(base64);
			System.out.println(url);
			File file = new File(url);
            String headUrl = QiniuUtil.commonUploadFile(file, "upload/faceImg");
            file.delete();
			int cnt  = userService.updatePersonalImg(headUrl, getUserId());
			if(cnt>0){
				return R.ok("更新图片成功!");
			}else{
				return R.error("更新图像失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("更新图像失败！");
		}
	}
	@ResponseBody
	@PostMapping("/updateHeadIcon")
	public FileVo updateImg(MultipartFile file, HttpServletRequest request) {
		FileVo fileVo = new FileVo();
		try{
			UserVo userVo = userService.get(getUserId());
			String url = QiniuUtil.uploadImage(file, "upload/faceImg");
			Map<String,String> data = new HashMap<String, String>();
			data.put("src",url);
			fileVo.setData(data);
			System.out.println("保存到数据库的图片地址:"+url);
			fileVo.setCode(0);
			//如果修改了头像择删除原来的头像
			QiniuUtil.deleteFile(userVo.getHeadIcon());
			userVo.setHeadIcon(url);
			userService.update(userVo);//保存头像
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
