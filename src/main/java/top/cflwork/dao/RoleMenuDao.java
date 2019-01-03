package top.cflwork.dao;

import top.cflwork.domain.RoleMenuVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单对应关系
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 11:08:59
 */
@Mapper
public interface RoleMenuDao {

	RoleMenuVo get(Long id);
	
	List<RoleMenuVo> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RoleMenuVo roleMenu);
	
	int update(RoleMenuVo roleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<Long> listMenuIdByRoleId(Long roleId);
	
	int removeByRoleId(Long roleId);

	int removeByMenuId(Long menuId);
	
	int batchSave(List<RoleMenuVo> list);
}
