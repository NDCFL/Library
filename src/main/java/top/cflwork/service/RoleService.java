package top.cflwork.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import top.cflwork.vo.RoleVo;

@Service
public interface RoleService {

	RoleVo get(String id);

	List<RoleVo> list(Map<String,Object> map);

	int save(RoleVo role);

	int update(RoleVo role);

	int remove(String id);

	List<RoleVo> list(String userId);

	int batchremove(String[] ids);
}
