package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.BorrowDao;
import top.cflwork.vo.BorrowVo;
import top.cflwork.service.BorrowService;
import top.cflwork.common.SequenceId;


@Service
public class BorrowServiceImpl implements BorrowService {
	@Autowired
	private BorrowDao borrowDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public BorrowVo get(String id){
		return borrowDao.get(id);
	}
	
	@Override
    @Transactional
	public List<BorrowVo> list(BorrowVo borrowVo){
		return borrowDao.list(borrowVo);
	}
	
	@Override
    @Transactional
	public long count(BorrowVo borrowVo){
		return borrowDao.count(borrowVo);
	}
	
	@Override
    @Transactional
	public int save(BorrowVo borrow){
	    borrow.setId(sequenceId.nextId());
	    return borrowDao.save(borrow);
	}
	
	@Override
    @Transactional
	public int update(BorrowVo borrow){
		return borrowDao.update(borrow);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return borrowDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return borrowDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<BorrowVo> borrowList){
			borrowList.forEach(e -> e.setId(sequenceId.nextId()));
        return borrowDao.batchSave(borrowList);
    }
}
