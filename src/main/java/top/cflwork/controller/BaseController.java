package top.cflwork.controller;

import top.cflwork.util.ShiroUtils;
import top.cflwork.vo.UserVo;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	public UserVo getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}