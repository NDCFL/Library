package top.cflwork.service;

import top.cflwork.vo.IntegralTypeVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 积分配置表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-23 16:17:48
 */
@Service
public interface IntegralTypeService {
	
	IntegralTypeVo get(String id);
	
	List<IntegralTypeVo> list(IntegralTypeVo integralTypeVo);
	
	long count(IntegralTypeVo integralTypeVo);
	
	int save(IntegralTypeVo integralType);
	
	int update(IntegralTypeVo integralType);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<IntegralTypeVo> integralTypeList);
}
