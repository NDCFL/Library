package top.cflwork.dao;

import top.cflwork.vo.ReaderBookVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 城市书房
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 17:36:12
 */
@Mapper
public interface ReaderBookDao {

	ReaderBookVo get(String id);
	
	List<ReaderBookVo> list(ReaderBookVo readerBookVo);
	
	long count(ReaderBookVo readerBookVo);
	
	int save(ReaderBookVo readerBook);
	
	int update(ReaderBookVo readerBook);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<ReaderBookVo> readerBookList);
}
