package top.cflwork.service;

import top.cflwork.vo.CourierOrderVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 快递订单管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:13:02
 */
@Service
public interface CourierOrderService {
	
	CourierOrderVo get(String id);
	
	List<CourierOrderVo> list(CourierOrderVo courierOrderVo);
	
	long count(CourierOrderVo courierOrderVo);
	
	int save(CourierOrderVo courierOrder);
	
	int update(CourierOrderVo courierOrder);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<CourierOrderVo> courierOrderList);
}
