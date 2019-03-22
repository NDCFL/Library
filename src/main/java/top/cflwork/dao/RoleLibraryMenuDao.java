package top.cflwork.dao;

import org.apache.ibatis.annotations.Mapper;
import top.cflwork.vo.RoleLibraryMenuVo;

import java.util.List;
import java.util.Map;

/**
 * 图书馆与菜单对应关系
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 11:08:59
 */
@Mapper
public interface RoleLibraryMenuDao {

	RoleLibraryMenuVo get(String id);

	List<RoleLibraryMenuVo> list(Map<String, Object> map);

	long count(Map<String, Object> map);
	
	int save(RoleLibraryMenuVo roleMenu);
	
	int update(RoleLibraryMenuVo roleMenu);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
	
	List<String> listLibraryMenuIdByLibraryId(String libraryId);
	
	long removeByLibraryId(String libraryId);

	int removeByLibraryMenuId(String menuId);
	
	int batchSave(List<RoleLibraryMenuVo> list);
}
