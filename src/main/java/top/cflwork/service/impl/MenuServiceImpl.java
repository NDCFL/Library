package top.cflwork.service.impl;

import top.cflwork.util.BuildTree;
import top.cflwork.dao.MenuDao;
import top.cflwork.dao.RoleMenuDao;
import top.cflwork.domain.MenuVo;
import top.cflwork.service.MenuService;
import top.cflwork.vo.Tree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuDao menuMapper;
	@Autowired
	RoleMenuDao roleMenuMapper;

	/**
	 * @param
	 * @return 树形菜单
	 */
	@Cacheable
	@Override
	public Tree<MenuVo> getSysMenuTree(Long id) {
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuDOs = menuMapper.listMenuByUserId(id);
		for (MenuVo sysMenuVo : menuDOs) {
			Tree<MenuVo> tree = new Tree<MenuVo>();
			tree.setId(sysMenuVo.getMenuId().toString());
			tree.setParentId(sysMenuVo.getParentId().toString());
			tree.setText(sysMenuVo.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", sysMenuVo.getUrl());
			attributes.put("icon", sysMenuVo.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuVo> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public List<MenuVo> list(Map<String, Object> params) {
		List<MenuVo> menus = menuMapper.list(params);
		return menus;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int remove(Long id) {
		int result = menuMapper.remove(id);
		return result;
	}
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int save(MenuVo menu) {
		int r = menuMapper.save(menu);
		return r;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int update(MenuVo menu) {
		int r = menuMapper.update(menu);
		return r;
	}

	@Override
	public MenuVo get(Long id) {
		MenuVo menuDO = menuMapper.get(id);
		return menuDO;
	}

	@Override
	public Tree<MenuVo> getTree() {
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuDOs = menuMapper.list(new HashMap<>(16));
		for (MenuVo sysMenuVo : menuDOs) {
			Tree<MenuVo> tree = new Tree<MenuVo>();
			tree.setId(sysMenuVo.getMenuId().toString());
			tree.setParentId(sysMenuVo.getParentId().toString());
			tree.setText(sysMenuVo.getName());
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuVo> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<MenuVo> getTree(Long id) {
		// 根据roleId查询权限
		List<MenuVo> menus = menuMapper.list(new HashMap<String, Object>(16));
		List<Long> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
		List<Long> temp = menuIds;
		for (MenuVo menu : menus) {
			if (temp.contains(menu.getParentId())) {
				menuIds.remove(menu.getParentId());
			}
		}
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuDOs = menuMapper.list(new HashMap<String, Object>(16));
		for (MenuVo sysMenuVo : menuDOs) {
			Tree<MenuVo> tree = new Tree<MenuVo>();
			tree.setId(sysMenuVo.getMenuId().toString());
			tree.setParentId(sysMenuVo.getParentId().toString());
			tree.setText(sysMenuVo.getName());
			Map<String, Object> state = new HashMap<>(16);
			Long menuId = sysMenuVo.getMenuId();
			if (menuIds.contains(menuId)) {
				state.put("selected", true);
			} else {
				state.put("selected", false);
			}
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuVo> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Set<String> listPerms(Long userId) {
		List<String> perms = menuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<Tree<MenuVo>> listMenuTree(Long id) {
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuDOs = menuMapper.listMenuByUserId(id);
		for (MenuVo sysMenuVo : menuDOs) {
			Tree<MenuVo> tree = new Tree<MenuVo>();
			tree.setId(sysMenuVo.getMenuId().toString());
			tree.setParentId(sysMenuVo.getParentId().toString());
			tree.setText(sysMenuVo.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", sysMenuVo.getUrl());
			attributes.put("icon", sysMenuVo.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<MenuVo>> list = BuildTree.buildList(trees, "0");
		return list;
	}

}
