package top.cflwork.service;

import top.cflwork.vo.SeatUseVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 座位预约管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:17:17
 */
@Service
public interface SeatUseService {
	
	SeatUseVo get(String id);
	
	List<SeatUseVo> list(SeatUseVo seatUseVo);
	
	long count(SeatUseVo seatUseVo);
	
	int save(SeatUseVo seatUse);
	
	int update(SeatUseVo seatUse);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<SeatUseVo> seatUseList);
}
