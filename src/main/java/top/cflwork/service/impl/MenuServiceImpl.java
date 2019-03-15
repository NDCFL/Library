package top.cflwork.service.impl;

import top.cflwork.common.SequenceId;
import top.cflwork.util.BuildTree;
import top.cflwork.dao.MenuDao;
import top.cflwork.dao.RoleMenuDao;
import top.cflwork.vo.MenuVo;
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
public class MenuServiceImpl implements MenuService  {
	@Autowired
	MenuDao menuMapper;
	@Autowired
	RoleMenuDao roleMenuMapper;
    @Autowired
    private SequenceId sequenceId;
	/**
	 * @param
	 * @return 树形菜单
	 */
	@Cacheable
	@Override
	public Tree<MenuVo> getSysMenuTree(String id) {
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuVos = menuMapper.listMenuByUserId(id);
		for (MenuVo sysMenuVo : menuVos) {
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
	public int remove(String id) {
	    //删除主菜单
		int result = menuMapper.remove(id);
		String stringList[] = menuMapper.findByParentId(id);
		if(stringList.length>0){
			menuMapper.batchRemove(stringList);
		}
		return result;
	}
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int save(MenuVo menu) {
	    menu.setMenuId(sequenceId.nextId());
		int r = menuMapper.save(menu);
		if(menu.getType()==1){
			String path = menu.getPerms().substring(0,menu.getPerms().indexOf(":"));
			List<MenuVo> menuVoList = new ArrayList<>();
			MenuVo menuVo = new MenuVo();
			menuVo.setParentId(menu.getMenuId());
			menuVo.setName("新增");
			menuVo.setType(2);
			menuVo.setPerms(path+":add");
			menuVo.setUrl("/"+path+"/add");
			menuVo.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo);

			MenuVo menuVo1 = new MenuVo();
			menuVo1.setParentId(menu.getMenuId());
			menuVo1.setName("删除");
			menuVo1.setType(2);
			menuVo1.setPerms(path+":remove");
			menuVo1.setUrl("/"+path+"/remove");
			menuVo1.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo1);

			MenuVo menuVo2 = new MenuVo();
			menuVo2.setParentId(menu.getMenuId());
			menuVo2.setName("编辑");
			menuVo2.setType(2);
			menuVo2.setPerms(path+":edit");
			menuVo2.setUrl("/"+path+"/edit");
			menuVo2.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo2);

			MenuVo menuVo3 = new MenuVo();
			menuVo3.setParentId(menu.getMenuId());
			menuVo3.setName("保存");
			menuVo3.setType(2);
			menuVo3.setPerms(path+":save");
			menuVo3.setUrl("/"+path+"/save");
			menuVo3.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo3);

			MenuVo menuVo4 = new MenuVo();
			menuVo4.setParentId(menu.getMenuId());
			menuVo4.setName("列表");
			menuVo4.setType(2);
			menuVo4.setPerms(path+":list");
			menuVo4.setUrl("/"+path+"/list");
			menuVo4.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo4);


			MenuVo menuVo5 = new MenuVo();
			menuVo5.setParentId(menu.getMenuId());
			menuVo5.setName("批量删除");
			menuVo5.setType(2);
			menuVo5.setPerms(path+":batchRemove");
			menuVo5.setUrl("/"+path+"/batchRemove");
			menuVo5.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo5);

			MenuVo menuVo6 = new MenuVo();
			menuVo6.setParentId(menu.getMenuId());
			menuVo6.setName("修改");
			menuVo6.setType(2);
			menuVo6.setPerms(path+":update");
			menuVo6.setUrl("/"+path+"/update");
			menuVo6.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo6);

			MenuVo menuVo7 = new MenuVo();
			menuVo7.setParentId(menu.getMenuId());
			menuVo7.setName("批量新增");
			menuVo7.setType(2);
			menuVo7.setPerms(path+":batchSave");
			menuVo7.setUrl("/"+path+"/batchSave");
			menuVo7.setMenuId(sequenceId.nextId());
			menuVoList.add(menuVo7);
			//批量新增
			menuMapper.batchSave(menuVoList);
		}
		return r;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int update(MenuVo menu) {
		int r = menuMapper.update(menu);
		return r;
	}

	@Override
	public MenuVo get(String id) {
		MenuVo menuVo = menuMapper.get(id);
		return menuVo;
	}

	@Override
	public Tree<MenuVo> getTree() {
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuVos = menuMapper.list(new HashMap<>(16));
		for (MenuVo sysMenuVo : menuVos) {
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
	public Tree<MenuVo> getTree(String id) {
		// 根据roleId查询权限
		List<MenuVo> menus = menuMapper.list(new HashMap<String, Object>(16));
		List<String> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
		List<String> temp = menuIds;
		for (MenuVo menu : menus) {
			if (temp.contains(menu.getParentId())) {
				menuIds.remove(menu.getParentId());
			}
		}
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuVos = menuMapper.list(new HashMap<String, Object>(16));
		for (MenuVo sysMenuVo : menuVos) {
			Tree<MenuVo> tree = new Tree<MenuVo>();
			tree.setId(sysMenuVo.getMenuId().toString());
			tree.setParentId(sysMenuVo.getParentId().toString());
			tree.setText(sysMenuVo.getName());
			Map<String, Object> state = new HashMap<>(16);
			String menuId = sysMenuVo.getMenuId();
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
	public Set<String> listPerms(String userId) {
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
    public int batchSave(List<MenuVo> menuVoList) {
        return menuMapper.batchSave(menuVoList);
    }

    @Override
	public List<Tree<MenuVo>> listMenuTree(String id) {
		List<Tree<MenuVo>> trees = new ArrayList<Tree<MenuVo>>();
		List<MenuVo> menuVos = menuMapper.listMenuByUserId(id);
		for (MenuVo sysMenuVo : menuVos) {
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
