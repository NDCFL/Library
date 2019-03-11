package top.cflwork.service;

import top.cflwork.vo.CollectionBookVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import top.cflwork.vo.xmlvo.BookSearchVo;

/**
 * 馆藏表
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-11 13:23:06
 */
@Service
public interface CollectionBookService {
	
	CollectionBookVo get(String id);
	
	List<CollectionBookVo> list(CollectionBookVo collectionBookVo);
	
	long count(CollectionBookVo collectionBookVo);
	
	int save(CollectionBookVo collectionBook);
	
	int update(CollectionBookVo collectionBook);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<CollectionBookVo> collectionBookList);





}
