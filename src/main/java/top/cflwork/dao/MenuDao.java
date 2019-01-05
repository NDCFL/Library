package top.cflwork.dao;

import top.cflwork.vo.MenuVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 09:45:09
 */
@Mapper
public interface MenuDao {

	MenuVo get(Long menuId);
	
	List<MenuVo> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MenuVo menu);
	
	int update(MenuVo menu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
	
	List<MenuVo> listMenuByUserId(Long id);
	
	List<String> listUserPerms(Long id);
}
