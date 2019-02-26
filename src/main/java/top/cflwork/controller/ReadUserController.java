package top.cflwork.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
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

import top.cflwork.common.ResponseJson;
import top.cflwork.common.XmlSendUtil;
import top.cflwork.config.Constant;
import top.cflwork.util.*;
import top.cflwork.vo.ReadUserVo;
import top.cflwork.service.ReadUserService;
import top.cflwork.vo.SendVo;
import top.cflwork.vo.xmlvo.ReadRootVo;

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
	@Autowired
	private XmlSendUtil xmlSendUtil;
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
	@PostMapping("/update")
	@RequiresPermissions("readUser:update")
	public R update( ReadUserVo readUser){
		readUserService.update(readUser);
		return R.ok("修改成功");
	}

	/**
	 * 重置密码
	 */
	@ResponseBody
	@GetMapping("/resetPwd/{id}")
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

	/**
	 * 登录
	 */
	@PostMapping( "/login")
	@ResponseBody
	@ApiOperation(value = "读者登录：传入卡号(cardNum)，密码(password)", notes = "返回读者信息")
	public ResponseJson login(@RequestBody ReadUserVo readUserVo) {
		try{
			ReadUserVo u = new ReadUserVo();
			u.setCardNum(readUserVo.getCardNum());
			long cnt = readUserService.count(u);
			ReadUserVo user = readUserService.getReadUser(readUserVo);
			if (cnt==0) {
				SendVo sendVo = new SendVo();
				sendVo.setWsUrl("DLibsAPI/services/ReaderWS");
				sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10020</eventType><cardno>"+readUserVo.getCardNum()+"</cardno><password>"+readUserVo.getPassword()+"</password></text></root>");
				ResponseJson responseJson  = xmlSendUtil.send(sendVo);
				if(responseJson.getResult().isSuccess()){
					ReadRootVo readRootVo = JaXmlBeanUtil.converyToJavaBean(responseJson.getResult().getMsg(), ReadRootVo.class);
					ReadUserVo readUserVo1 = new ReadUserVo();
					//调用接口可以查询到
					if(readRootVo.getText()==null){
						return new ResponseJson(false, "错误的用户名或密码");
					}else{
						readUserVo1.setPassword(readUserVo.getPassword());
						readUserVo1.setCardNum(readRootVo.getText().getCardno());
						readUserVo1.setPhone(readRootVo.getText().getMobile());
						readUserVo1.setName(readRootVo.getText().getName());
						readUserVo1.setSex(readRootVo.getText().getGender()=="男"?0:1);
						readUserService.save(readUserVo1);
						String token = JwtUtil.createJWT(readUserVo.getPhone(), "{}", null, -1);
						return new ResponseJson(true, token, user);
					}
				}else{
					return new ResponseJson(false, "错误的用户名或密码");
				}
			} else {
				if(user==null){
					return new ResponseJson(false, "错误的用户名或密码");
				}else{
					String token = JwtUtil.createJWT(readUserVo.getPhone(), "{}", null, -1);
					return new ResponseJson(true, token, user);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseJson(false, "服务器异常");
		}
	}

	public static void main(String[] args) {
		SendVo sendVo = new SendVo();
		sendVo.setWsUrl("DLibsAPI/services/ReaderWS");
		sendVo.setXmlParams(Constant.XMLPARAMS+"<text><eventType>10020</eventType><cardno>QHL0000701</cardno><password>123456</password></text></root>");
		ResponseJson responseJson  = new XmlSendUtil().send(sendVo);
		System.out.println(responseJson.getResult().getMsg());
	}
}
