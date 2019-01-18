package top.cflwork.service;

import top.cflwork.vo.ReadingRoomVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 阅览室管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 16:16:56
 */
@Service
public interface ReadingRoomService {
	
	ReadingRoomVo get(String id);
	
	List<ReadingRoomVo> list(ReadingRoomVo readingRoomVo);
	
	long count(ReadingRoomVo readingRoomVo);
	
	int save(ReadingRoomVo readingRoom);
	
	int update(ReadingRoomVo readingRoom);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<ReadingRoomVo> readingRoomList);
}
