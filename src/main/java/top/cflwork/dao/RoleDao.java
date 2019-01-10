package top.cflwork.dao;

import top.cflwork.vo.RoleVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-02 20:24:47
 */
@Mapper
public interface RoleDao {

	RoleVo get(String roleId);
	
	List<RoleVo> list(Map<String,Object> map);
	
	long count(Map<String,Object> map);
	
	int save(RoleVo role);
	
	int update(RoleVo role);

	int remove(String roleId);
	
	int batchRemove(String[] roleIds);
}
