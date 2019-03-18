package top.cflwork.service.impl;

import top.cflwork.common.SequenceId;
import top.cflwork.dao.DeptDao;
import top.cflwork.vo.DeptVo;
import top.cflwork.service.DeptService;
import top.cflwork.vo.Tree;
import top.cflwork.util.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao sysDeptMapper;
	@Autowired
	private SequenceId sequenceId;

	@Override
	public DeptVo get(String deptId){
		return sysDeptMapper.get(deptId);
	}

	@Override
	public List<DeptVo> list(Map<String, Object> map){
		return sysDeptMapper.list(map);
	}

	@Override
	public long count(Map<String, Object> map){
		return sysDeptMapper.count(map);
	}

	@Override
	public int save(DeptVo sysDept){
		sysDept.setDeptId(sequenceId.nextId());
		return sysDeptMapper.save(sysDept);
	}

	@Override
	public int update(DeptVo sysDept){
		return sysDeptMapper.update(sysDept);
	}

	@Override
	public int remove(String deptId){
		return sysDeptMapper.remove(deptId);
	}

	@Override
	public int batchRemove(String[] deptIds){
		return sysDeptMapper.batchRemove(deptIds);
	}

	@Override
	public Tree<DeptVo> getTree() {
		List<Tree<DeptVo>> trees = new ArrayList<Tree<DeptVo>>();
		List<DeptVo> sysDepts = sysDeptMapper.list(new HashMap<String,Object>(16));
		for (DeptVo sysDept : sysDepts) {
			Tree<DeptVo> tree = new Tree<DeptVo>();
			tree.setId(sysDept.getDeptId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptVo> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public boolean checkDeptHasUser(String deptId) {
		// TOVo Auto-generated method stub
		//查询部门以及此部门的下级部门
		int result = sysDeptMapper.getDeptUserNumber(deptId);
		return result==0?true:false;
	}

}
