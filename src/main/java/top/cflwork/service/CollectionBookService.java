package top.cflwork.service;

import top.cflwork.vo.CollectionBookVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 图书书目信息
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-07 17:23:37
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
