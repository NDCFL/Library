package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.common.SequenceId;
import top.cflwork.dao.BookDao;
import top.cflwork.vo.BookVo;
import top.cflwork.service.BookService;



@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private SequenceId sequenceId;
	@Override
    @Transactional
	public BookVo get(String id){
		return bookDao.get(id);
	}
	
	@Override
    @Transactional
	public List<BookVo> list(BookVo bookVo){
		return bookDao.list(bookVo);
	}
	
	@Override
    @Transactional
	public long count(BookVo bookVo){
		return bookDao.count(bookVo);
	}
	
	@Override
    @Transactional
	public int save(BookVo book){
		book.setId(sequenceId.nextId());
		return bookDao.save(book);
	}
	
	@Override
    @Transactional
	public int update(BookVo book){
		return bookDao.update(book);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return bookDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String ids[]){
		return bookDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<BookVo> bookList){
        bookList.stream().forEach(e->{
        	e.setId(sequenceId.nextId());
		});
		return bookDao.batchSave(bookList);
    }
}
