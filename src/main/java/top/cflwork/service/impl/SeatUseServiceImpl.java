package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.SeatUseDao;
import top.cflwork.vo.SeatUseVo;
import top.cflwork.service.SeatUseService;
import top.cflwork.common.SequenceId;


@Service
public class SeatUseServiceImpl implements SeatUseService {
	@Autowired
	private SeatUseDao seatUseDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public SeatUseVo get(String id){
		return seatUseDao.get(id);
	}
	
	@Override
    @Transactional
	public List<SeatUseVo> list(SeatUseVo seatUseVo){
		return seatUseDao.list(seatUseVo);
	}
	
	@Override
    @Transactional
	public long count(SeatUseVo seatUseVo){
		return seatUseDao.count(seatUseVo);
	}
	
	@Override
    @Transactional
	public int save(SeatUseVo seatUse){
	    seatUse.setId(sequenceId.nextId());
	    return seatUseDao.save(seatUse);
	}
	
	@Override
    @Transactional
	public int update(SeatUseVo seatUse){
		return seatUseDao.update(seatUse);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return seatUseDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return seatUseDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<SeatUseVo> seatUseList){
			seatUseList.forEach(e -> e.setId(sequenceId.nextId()));
        return seatUseDao.batchSave(seatUseList);
    }
}
