package top.cflwork.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import top.cflwork.vo.BookVo;

/**
 * 图书表
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-04 20:10:23
 */
@Mapper
public interface BookDao {

	BookVo get(Long id);
	
	List<BookVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BookVo book);
	
	int update(BookVo book);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int batchSave(List<BookVo> bookList);
}
