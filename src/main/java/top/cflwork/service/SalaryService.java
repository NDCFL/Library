package top.cflwork.service;

import top.cflwork.domain.SalaryVo;

import java.util.List;
import java.util.Map;

/**
 * 审批流程测试表
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-11-25 13:33:16
 */
public interface SalaryService {
	
	SalaryVo get(String id);
	
	List<SalaryVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SalaryVo salary);
	
	int update(SalaryVo salary);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
