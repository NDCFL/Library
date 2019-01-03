package top.cflwork.dao;

import top.cflwork.domain.DeptVo;

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

	DeptVo get(Long deptId);
	
	List<DeptVo> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DeptVo dept);
	
	int update(DeptVo dept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);
	
	Long[] listParentDept();
	
	int getDeptUserNumber(Long deptId);
}
