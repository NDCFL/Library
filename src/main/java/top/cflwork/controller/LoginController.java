package top.cflwork.controller;

import org.springframework.web.servlet.ModelAndView;
import top.cflwork.common.annotation.Log;
import top.cflwork.config.Constant;
import top.cflwork.util.MD5Utils;
import top.cflwork.util.R;
import top.cflwork.util.ShiroUtils;
import top.cflwork.vo.MenuVo;
import top.cflwork.service.FileService;
import top.cflwork.service.MenuService;
import top.cflwork.vo.FileListVo;
import top.cflwork.vo.Tree;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public MenuService menuService;
	@Autowired
    public FileService fileService;
	@GetMapping({ "/", "" })
    public String welcome(Model model) {

		return "redirect:/login";
	}

	@Log("请求访问主页")
	@GetMapping({ "/index" })
    public ModelAndView index(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<Tree<MenuVo>> menus = menuService.listMenuTree(getUserId());
		modelAndView.addObject("menus", menus);
		modelAndView.addObject("name", getUser().getName());
		if(getUser().getHeadIcon()!=null){
			model.addAttribute("headIcon", Constant.PATH+getUser().getHeadIcon());
		}else {
			model.addAttribute("headIcon","/img/photo_s.jpg");
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/login")
    public String login() {
		return "login";
	}

	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
    public R ajaxLogin(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

	@GetMapping("/logout")
    public String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
    public String main() {
		return "main";
	}

}
