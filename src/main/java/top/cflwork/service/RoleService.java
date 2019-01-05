package top.cflwork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import top.cflwork.vo.RoleVo;

@Service
public interface RoleService {

	RoleVo get(Long id);

	List<RoleVo> list();

	int save(RoleVo role);

	int update(RoleVo role);

	int remove(Long id);

	List<RoleVo> list(Long userId);

	int batchremove(Long[] ids);
}
