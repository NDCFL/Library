package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.SeatDao;
import top.cflwork.vo.SeatVo;
import top.cflwork.service.SeatService;
import top.cflwork.common.SequenceId;


@Service
public class SeatServiceImpl implements SeatService {
	@Autowired
	private SeatDao seatDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public SeatVo get(String id){
		return seatDao.get(id);
	}
	
	@Override
    @Transactional
	public List<SeatVo> list(SeatVo seatVo){
		return seatDao.list(seatVo);
	}
	
	@Override
    @Transactional
	public long count(SeatVo seatVo){
		return seatDao.count(seatVo);
	}
	
	@Override
    @Transactional
	public int save(SeatVo seat){
	    seat.setId(sequenceId.nextId());
	    return seatDao.save(seat);
	}
	
	@Override
    @Transactional
	public int update(SeatVo seat){
		return seatDao.update(seat);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return seatDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return seatDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<SeatVo> seatList){
			seatList.forEach(e -> e.setId(sequenceId.nextId()));
        return seatDao.batchSave(seatList);
    }
}
