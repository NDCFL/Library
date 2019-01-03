package top.cflwork.dao;

import top.cflwork.domain.SalaryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 审批流程测试表
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-11-25 13:28:58
 */
@Mapper
public interface SalaryDao {

	SalaryVo get(String id);
	
	List<SalaryVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SalaryVo salary);
	
	int update(SalaryVo salary);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
