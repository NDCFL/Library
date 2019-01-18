package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.BookTypeDao;
import top.cflwork.vo.BookTypeVo;
import top.cflwork.service.BookTypeService;
import top.cflwork.common.SequenceId;


@Service
public class BookTypeServiceImpl implements BookTypeService {
	@Autowired
	private BookTypeDao bookTypeDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public BookTypeVo get(String id){
		return bookTypeDao.get(id);
	}
	
	@Override
    @Transactional
	public List<BookTypeVo> list(BookTypeVo bookTypeVo){
		return bookTypeDao.list(bookTypeVo);
	}
	
	@Override
    @Transactional
	public long count(BookTypeVo bookTypeVo){
		return bookTypeDao.count(bookTypeVo);
	}
	
	@Override
    @Transactional
	public int save(BookTypeVo bookType){
	    bookType.setId(sequenceId.nextId());
	    return bookTypeDao.save(bookType);
	}
	
	@Override
    @Transactional
	public int update(BookTypeVo bookType){
		return bookTypeDao.update(bookType);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return bookTypeDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return bookTypeDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<BookTypeVo> bookTypeList){
			bookTypeList.forEach(e -> e.setId(sequenceId.nextId()));
        return bookTypeDao.batchSave(bookTypeList);
    }
}
