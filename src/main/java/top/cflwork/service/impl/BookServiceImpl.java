package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.BookDao;
import top.cflwork.vo.BookVo;
import top.cflwork.service.BookService;



@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	@Override
    @Transactional
	public BookVo get(Long id){
		return bookDao.get(id);
	}
	
	@Override
    @Transactional
	public List<BookVo> list(Map<String, Object> map){
		return bookDao.list(map);
	}
	
	@Override
    @Transactional
	public int count(Map<String, Object> map){
		return bookDao.count(map);
	}
	
	@Override
    @Transactional
	public int save(BookVo book){
		return bookDao.save(book);
	}
	
	@Override
    @Transactional
	public int update(BookVo book){
		return bookDao.update(book);
	}
	
	@Override
    @Transactional
	public int remove(Long id){
		return bookDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(Long[] ids){
		return bookDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<BookVo> bookList){
        return bookDao.batchSave(bookList);
    }
}
