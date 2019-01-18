package top.cflwork.service;

import top.cflwork.vo.BookTypeVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 图书分类
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-15 18:01:18
 */
@Service
public interface BookTypeService {
	
	BookTypeVo get(String id);
	
	List<BookTypeVo> list(BookTypeVo bookTypeVo);
	
	long count(BookTypeVo bookTypeVo);
	
	int save(BookTypeVo bookType);
	
	int update(BookTypeVo bookType);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<BookTypeVo> bookTypeList);
}
