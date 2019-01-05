package top.cflwork.service;

import top.cflwork.vo.BookVo;

import java.util.List;
import java.util.Map;

/**
 * 图书表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-05 12:32:55
 */
public interface BookService {
	
	BookVo get(Long id);
	
	List<BookVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BookVo book);
	
	int update(BookVo book);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

    int batchSave(List<BookVo> bookList);
}
