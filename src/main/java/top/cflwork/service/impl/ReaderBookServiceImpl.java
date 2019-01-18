package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.ReaderBookDao;
import top.cflwork.vo.ReaderBookVo;
import top.cflwork.service.ReaderBookService;
import top.cflwork.common.SequenceId;


@Service
public class ReaderBookServiceImpl implements ReaderBookService {
	@Autowired
	private ReaderBookDao readerBookDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public ReaderBookVo get(String id){
		return readerBookDao.get(id);
	}
	
	@Override
    @Transactional
	public List<ReaderBookVo> list(ReaderBookVo readerBookVo){
		return readerBookDao.list(readerBookVo);
	}
	
	@Override
    @Transactional
	public long count(ReaderBookVo readerBookVo){
		return readerBookDao.count(readerBookVo);
	}
	
	@Override
    @Transactional
	public int save(ReaderBookVo readerBook){
	    readerBook.setId(sequenceId.nextId());
	    return readerBookDao.save(readerBook);
	}
	
	@Override
    @Transactional
	public int update(ReaderBookVo readerBook){
		return readerBookDao.update(readerBook);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return readerBookDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return readerBookDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<ReaderBookVo> readerBookList){
			readerBookList.forEach(e -> e.setId(sequenceId.nextId()));
        return readerBookDao.batchSave(readerBookList);
    }
}
