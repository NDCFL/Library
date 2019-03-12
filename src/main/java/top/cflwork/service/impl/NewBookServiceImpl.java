package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.NewBookDao;
import top.cflwork.vo.NewBookVo;
import top.cflwork.service.NewBookService;
import top.cflwork.common.SequenceId;
import top.cflwork.vo.xmlvo.NewBooksVo;


@Service
public class NewBookServiceImpl implements NewBookService {
	@Autowired
	private NewBookDao newBookDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public NewBookVo get(String id){
		return newBookDao.get(id);
	}
	
	@Override
    @Transactional
	public List<NewBookVo> list(NewBookVo newBookVo){
		return newBookDao.list(newBookVo);
	}
	
	@Override
    @Transactional
	public long count(NewBookVo newBookVo){
		return newBookDao.count(newBookVo);
	}
	
	@Override
    @Transactional
	public int save(NewBookVo newBook){
	    newBook.setId(sequenceId.nextId());
	    return newBookDao.save(newBook);
	}
	
	@Override
    @Transactional
	public int update(NewBookVo newBook){
		return newBookDao.update(newBook);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return newBookDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return newBookDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<NewBookVo> newBookList){
			newBookList.forEach(e -> e.setId(sequenceId.nextId()));
        return newBookDao.batchSave(newBookList);
    }

	@Override
	public int bachSaveNewBook(List<NewBooksVo> newBooksVoList) {
		newBooksVoList.stream().forEach(e->{
			e.setId(sequenceId.nextId());
		});
		return newBookDao.bachSaveNewBook(newBooksVoList);
	}
}
