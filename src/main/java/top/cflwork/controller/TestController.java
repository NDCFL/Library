package top.cflwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Transient;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("index")
    public String index() throws Exception {
        return "/ueditor/index";
    }

    /**
     * 测试xml调用
     */




}
