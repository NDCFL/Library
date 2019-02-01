package top.cflwork.dao;

import top.cflwork.vo.DeptVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 15:35:39
 */
@Mapper
public interface DeptDao {

	DeptVo get(String deptId);
	
	List<DeptVo> list(Map<String,Object> map);
	
	long count(Map<String,Object> map);
	
	int save(DeptVo dept);
	
	int update(DeptVo dept);
	
	int remove(String deptId);
	
	int batchRemove(String[] deptIds);
	
	String[] listParentDept();
	
	int getDeptUserNumber(String deptId);
}
