package top.cflwork.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cflwork.common.XmlSendUtil;
import top.cflwork.service.ReadUserService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.R;
import top.cflwork.vo.ReadUserVo;

import java.util.List;

@Controller
@RequestMapping("readUserExpress")
public class ReadUserExpressController {
    @Autowired
    private ReadUserService readUserService;
    @Autowired
    private XmlSendUtil xmlSendUtil;
    @GetMapping("readUserExpressPage")
    @RequiresPermissions("readUserExpress:readUserExpressPage")
    public String ReadUser(){
        return "/readUser/readUserExpress";
    }

    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("readUserExpress:list")
    public PageUtils list(ReadUserVo readUserVo){
        //查询列表数据
        List<ReadUserVo> readUserList = readUserService.list(readUserVo);
        Long total = readUserService.count(readUserVo);
        PageUtils pageUtils = new PageUtils(readUserList, total);
        return pageUtils;
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


}
