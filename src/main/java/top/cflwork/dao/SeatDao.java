package top.cflwork.dao;

import top.cflwork.vo.SeatVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 座位管理
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 16:51:25
 */
@Mapper
public interface SeatDao {

	SeatVo get(String id);
	
	List<SeatVo> list(SeatVo seatVo);
	
	long count(SeatVo seatVo);
	
	int save(SeatVo seat);
	
	int update(SeatVo seat);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<SeatVo> seatList);
}
