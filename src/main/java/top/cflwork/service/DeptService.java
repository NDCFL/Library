package top.cflwork.service;

import top.cflwork.vo.DeptVo;
import top.cflwork.vo.Tree;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-27 14:28:36
 */
public interface DeptService {
	
	DeptVo get(String deptId);
	
	List<DeptVo> list(Map<String, Object> map);
	
	long count(Map<String, Object> map);
	
	int save(DeptVo sysDept);
	
	int update(DeptVo sysDept);
	
	int remove(String deptId);
	
	int batchRemove(String[] deptIds);

	Tree<DeptVo> getTree();

	boolean checkDeptHasUser(String deptId);
}
