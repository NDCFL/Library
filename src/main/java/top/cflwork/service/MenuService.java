package top.cflwork.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import top.cflwork.vo.Tree;
import org.springframework.stereotype.Service;

import top.cflwork.vo.MenuVo;

@Service
public interface MenuService {
	Tree<MenuVo> getSysMenuTree(String id);

	List<Tree<MenuVo>> listMenuTree(String id);

	Tree<MenuVo> getTree();

	Tree<MenuVo> getTree(String id);

	List<MenuVo> list(Map<String, Object> params);

	int remove(String id);

	int save(MenuVo menu);

	int update(MenuVo menu);

	MenuVo get(String id);

	Set<String> listPerms(String userId);
}
