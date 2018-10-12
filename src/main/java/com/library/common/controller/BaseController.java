package com.library.common.controller;

import com.library.system.domain.UserToken;
import org.springframework.stereotype.Controller;
import com.library.common.utils.ShiroUtils;
import com.library.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}