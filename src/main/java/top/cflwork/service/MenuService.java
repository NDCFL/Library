package top.cflwork.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import top.cflwork.vo.Tree;
import org.springframework.stereotype.Service;

import top.cflwork.domain.MenuVo;

@Service
public interface MenuService {
	Tree<MenuVo> getSysMenuTree(Long id);

	List<Tree<MenuVo>> listMenuTree(Long id);

	Tree<MenuVo> getTree();

	Tree<MenuVo> getTree(Long id);

	List<MenuVo> list(Map<String, Object> params);

	int remove(Long id);

	int save(MenuVo menu);

	int update(MenuVo menu);

	MenuVo get(Long id);

	Set<String> listPerms(Long userId);
}
