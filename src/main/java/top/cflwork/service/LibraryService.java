package top.cflwork.service;

import top.cflwork.vo.LibraryVo;
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
public interface LibraryService {
	
	LibraryVo get(String deptId);
	
	List<LibraryVo> list(Map<String, Object> map);
	
	long count(Map<String, Object> map);
	
	int save(LibraryVo sysLibrary);
	
	int update(LibraryVo sysLibrary);
	
	int remove(String deptId);
	
	int batchRemove(String[] deptIds);

	Tree<LibraryVo> getTree();

	boolean checkLibraryHasUser(String deptId);
}
