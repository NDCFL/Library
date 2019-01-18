package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.CourierOrderDao;
import top.cflwork.vo.CourierOrderVo;
import top.cflwork.service.CourierOrderService;
import top.cflwork.common.SequenceId;


@Service
public class CourierOrderServiceImpl implements CourierOrderService {
	@Autowired
	private CourierOrderDao courierOrderDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public CourierOrderVo get(String id){
		return courierOrderDao.get(id);
	}
	
	@Override
    @Transactional
	public List<CourierOrderVo> list(CourierOrderVo courierOrderVo){
		return courierOrderDao.list(courierOrderVo);
	}
	
	@Override
    @Transactional
	public long count(CourierOrderVo courierOrderVo){
		return courierOrderDao.count(courierOrderVo);
	}
	
	@Override
    @Transactional
	public int save(CourierOrderVo courierOrder){
	    courierOrder.setId(sequenceId.nextId());
	    return courierOrderDao.save(courierOrder);
	}
	
	@Override
    @Transactional
	public int update(CourierOrderVo courierOrder){
		return courierOrderDao.update(courierOrder);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return courierOrderDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return courierOrderDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<CourierOrderVo> courierOrderList){
			courierOrderList.forEach(e -> e.setId(sequenceId.nextId()));
        return courierOrderDao.batchSave(courierOrderList);
    }
}
