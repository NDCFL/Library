package top.cflwork.dao;

import top.cflwork.vo.ReadingRoomVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import top.cflwork.vo.Select2Vo;

/**
 * 阅览室管理
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 16:16:56
 */
@Mapper
public interface ReadingRoomDao {

	ReadingRoomVo get(String id);
	
	List<ReadingRoomVo> list(ReadingRoomVo readingRoomVo);
	
	long count(ReadingRoomVo readingRoomVo);
	
	int save(ReadingRoomVo readingRoom);
	
	int update(ReadingRoomVo readingRoom);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<ReadingRoomVo> readingRoomList);

	List<Select2Vo> getReaddingRoom();
}
