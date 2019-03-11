package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.CollectionBookDao;
import top.cflwork.vo.CollectionBookVo;
import top.cflwork.service.CollectionBookService;
import top.cflwork.common.SequenceId;
import top.cflwork.vo.xmlvo.BookSearchVo;


@Service
public class CollectionBookServiceImpl implements CollectionBookService {
	@Autowired
	private CollectionBookDao collectionBookDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public CollectionBookVo get(String id){
		return collectionBookDao.get(id);
	}
	
	@Override
    @Transactional
	public List<CollectionBookVo> list(CollectionBookVo collectionBookVo){
		return collectionBookDao.list(collectionBookVo);
	}
	
	@Override
    @Transactional
	public long count(CollectionBookVo collectionBookVo){
		return collectionBookDao.count(collectionBookVo);
	}
	
	@Override
    @Transactional
	public int save(CollectionBookVo collectionBook){
	    collectionBook.setId(sequenceId.nextId());
	    return collectionBookDao.save(collectionBook);
	}
	
	@Override
    @Transactional
	public int update(CollectionBookVo collectionBook){
		return collectionBookDao.update(collectionBook);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return collectionBookDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return collectionBookDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<CollectionBookVo> collectionBookList){
			collectionBookList.forEach(e -> e.setId(sequenceId.nextId()));
        return collectionBookDao.batchSave(collectionBookList);
    }

}
