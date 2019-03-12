package top.cflwork.service;

import top.cflwork.vo.NewBookVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import top.cflwork.vo.xmlvo.NewBooksVo;

/**
 * 
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-12 11:02:18
 */
@Service
public interface NewBookService {
	
	NewBookVo get(String id);
	
	List<NewBookVo> list(NewBookVo newBookVo);
	
	long count(NewBookVo newBookVo);
	
	int save(NewBookVo newBook);
	
	int update(NewBookVo newBook);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<NewBookVo> newBookList);

	int bachSaveNewBook(List<NewBooksVo> newBooksVoList);

}
