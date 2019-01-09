package top.cflwork.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by chenfeilong on 2017/10/18.
 */
@Controller
@RequestMapping("ueditor")
public class UeditorController {
    /**
     * 替换原始的ue的controller.jsp
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("core")
    public void core(HttpServletResponse response, HttpServletRequest request) throws Exception {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String rootPath = ResourceUtils.getURL("classpath:static").getPath();
        out.write( new ActionEnter( request, rootPath ).exec() );
    }
}
