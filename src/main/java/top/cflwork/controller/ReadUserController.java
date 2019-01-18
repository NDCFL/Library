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

import top.cflwork.util.MD5Utils;
import top.cflwork.vo.ReadUserVo;
import top.cflwork.service.ReadUserService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 读者管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 10:31:43
 */
 
@Controller
@RequestMapping("/readUser")
public class ReadUserController {
	@Autowired
	private ReadUserService readUserService;
	
	@GetMapping("readUserPage")
	@RequiresPermissions("readUser:readUserPage")
	public String ReadUser(){
	    return "/readUser/readUser";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("readUser:list")
	public PageUtils list(ReadUserVo readUserVo){
		//查询列表数据
		List<ReadUserVo> readUserList = readUserService.list(readUserVo);
		Long total = readUserService.count(readUserVo);
		PageUtils pageUtils = new PageUtils(readUserList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("readUser:add")
	public String add(){
	    return "/readUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("bookType:edit")
	@ResponseBody
	public ReadUserVo edit(@PathVariable("id") String id){
		ReadUserVo readUserVo = readUserService.get(id);
		return readUserVo;
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("readUser:add")
	public R save( ReadUserVo readUser){
		if(readUserService.save(readUser)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("readUser:update")
	public R update( ReadUserVo readUser){
		readUserService.update(readUser);
		return R.ok("修改成功");
	}

	/**
	 * 重置密码
	 */
	@ResponseBody
	@RequestMapping("/resetPwd/{id}")
	@RequiresPermissions("readUser:update")
	public R resetPwd(@PathVariable("id") String id){
		try{
			ReadUserVo r = new ReadUserVo();
			ReadUserVo readUserVo = readUserService.get(id);
			readUserVo.setPassword(MD5Utils.encrypt(readUserVo.getName(), "66666666"));
			r.setId(id);
			r.setPassword(readUserVo.getPassword());
			readUserService.update(r);
			return R.ok("密码重置成功:66666666");
		}catch (Exception e){
			return R.error("密码重置失败");
		}

	}
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("readUser:remove")
	public R remove( String id){
		if(readUserService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("readUser:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		readUserService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("readUser:batchSave")
    public R batchSave(List<ReadUserVo> readUserList){
			readUserService.batchSave(readUserList);
        return R.ok("批量新增成功");
    }
}
