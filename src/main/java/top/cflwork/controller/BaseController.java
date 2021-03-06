package top.cflwork.controller;

import top.cflwork.util.ShiroUtils;
import top.cflwork.vo.UserVo;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	public UserVo getUser() {
		return ShiroUtils.getUser();
	}

	public String getUserId() {
		return getUser().getUserId();
	}

	public String getLibraryId() {
		return getUser().getLibraryId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}