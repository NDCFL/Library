package top.cflwork.dao;

import top.cflwork.vo.CourierOrderVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 快递订单管理
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:13:02
 */
@Mapper
public interface CourierOrderDao {

	CourierOrderVo get(String id);
	
	List<CourierOrderVo> list(CourierOrderVo courierOrderVo);
	
	long count(CourierOrderVo courierOrderVo);
	
	int save(CourierOrderVo courierOrder);
	
	int update(CourierOrderVo courierOrder);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<CourierOrderVo> courierOrderList);
}
