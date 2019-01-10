package top.cflwork.dao;

import top.cflwork.vo.UserRoleVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色对应关系
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 11:08:59
 */
@Mapper
public interface UserRoleDao {

	UserRoleVo get(String id);

	List<UserRoleVo> list(Map<String, Object> map);

	long count(Map<String, Object> map);

	int save(UserRoleVo userRole);

	int update(UserRoleVo userRole);

	int remove(String id);

	int batchRemove(String[] ids);

	List<String> listRoleId(String userId);

	int removeByUserId(String userId);

	int removeByRoleId(String roleId);

	int batchSave(List<UserRoleVo> list);

	int batchRemoveByUserId(String[] ids);
}
