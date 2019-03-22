package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cflwork.common.SequenceId;
import top.cflwork.dao.*;
import top.cflwork.service.LibraryService;
import top.cflwork.util.BuildTree;
import top.cflwork.vo.LibraryVo;
import top.cflwork.vo.RoleLibraryMenuVo;
import top.cflwork.vo.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibraryDao sysLibraryMapper;
	@Autowired
	RoleLibraryMenuDao roleLibraryMenuDao;
	@Autowired
	UserDao userMapper;
	@Autowired
	LibraryDao libraryDao;
	@Autowired
	private SequenceId sequenceId;

	@Override
	public LibraryVo get(String libraryId){
		return sysLibraryMapper.get(libraryId);
	}

	@Override
	public List<LibraryVo> list(Map<String, Object> map){
		return sysLibraryMapper.list(map);
	}

	@Override
	public long count(Map<String, Object> map){
		return sysLibraryMapper.count(map);
	}

	@Override
	public int save(LibraryVo sysLibrary){
		sysLibrary.setLibraryId(sequenceId.nextId());
		int cnt = sysLibraryMapper.save(sysLibrary);
		List<String> menuIds = sysLibrary.getLibraryMenuIds();
		String libraryId = sysLibrary.getLibraryId();
		List<RoleLibraryMenuVo> rms = new ArrayList<>();
		for (String menuId : menuIds) {
			RoleLibraryMenuVo rmDo = new RoleLibraryMenuVo();
			rmDo.setLibraryId(libraryId);
			rmDo.setMenuId(menuId);
			rms.add(rmDo);
		}
		roleLibraryMenuDao.removeByLibraryId(libraryId);
		if (rms.size() > 0) {
			rms.stream().forEach(e->{
				e.setId(sequenceId.nextId());
			});
			roleLibraryMenuDao.batchSave(rms);
		}
		return cnt ;
	}

	@Override
	public int update(LibraryVo sysLibrary){
		int cnt = sysLibraryMapper.update(sysLibrary);
		List<String> menuIds = sysLibrary.getLibraryMenuIds();
		String libraryId = sysLibrary.getLibraryId();
		List<RoleLibraryMenuVo> rms = new ArrayList<>();
		for (String menuId : menuIds) {
			RoleLibraryMenuVo rmDo = new RoleLibraryMenuVo();
			rmDo.setLibraryId(libraryId);
			rmDo.setMenuId(menuId);
			rms.add(rmDo);
		}
		roleLibraryMenuDao.removeByLibraryId(libraryId);
		if (rms.size() > 0) {
			rms.stream().forEach(e->{
				e.setId(sequenceId.nextId());
			});
			roleLibraryMenuDao.batchSave(rms);
		}
		return cnt;
	}

	@Override
	public int remove(String libraryId){
		//删除图书馆
		int count = sysLibraryMapper.remove(libraryId);
		//删除图书馆权限
		roleLibraryMenuDao.removeByLibraryId(libraryId);
		return count;
	}

	@Override
	public int batchRemove(String[] libraryIds){
		return sysLibraryMapper.batchRemove(libraryIds);
	}

	@Override
	public Tree<LibraryVo> getTree() {
		List<Tree<LibraryVo>> trees = new ArrayList<Tree<LibraryVo>>();
		List<LibraryVo> sysLibrarys = sysLibraryMapper.list(new HashMap<String,Object>(16));
		for (LibraryVo sysLibrary : sysLibrarys) {
			Tree<LibraryVo> tree = new Tree<LibraryVo>();
			tree.setId(sysLibrary.getLibraryId().toString());
			tree.setParentId(sysLibrary.getParentId().toString());
			tree.setText(sysLibrary.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<LibraryVo> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public boolean checkLibraryHasUser(String libraryId) {
		// TOVo Auto-generated method stub
		//查询部门以及此部门的下级部门
		int result = sysLibraryMapper.getLibraryUserNumber(libraryId);
		return result==0?true:false;
	}

}
