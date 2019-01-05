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
	
	DeptVo get(Long deptId);
	
	List<DeptVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptVo sysDept);
	
	int update(DeptVo sysDept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);

	Tree<DeptVo> getTree();

	boolean checkDeptHasUser(Long deptId);
}
