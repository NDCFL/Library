package top.cflwork.service;

import java.io.PrintStream;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import top.cflwork.vo.UserVo;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import top.cflwork.vo.UserOnline;

@Service
public interface SessionService {
	List<UserOnline> list();

	List<UserVo> listOnlineUser();

	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}
