package top.cflwork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import top.cflwork.vo.RoleVo;

@Service
public interface RoleService {

	RoleVo get(String id);

	List<RoleVo> list();

	int save(RoleVo role);

	int update(RoleVo role);

	int remove(String id);

	List<RoleVo> list(String userId);

	int batchremove(String[] ids);
}
