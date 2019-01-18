package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.ElectronExpressDao;
import top.cflwork.vo.ElectronExpressVo;
import top.cflwork.service.ElectronExpressService;
import top.cflwork.common.SequenceId;


@Service
public class ElectronExpressServiceImpl implements ElectronExpressService {
	@Autowired
	private ElectronExpressDao electronExpressDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public ElectronExpressVo get(String id){
		return electronExpressDao.get(id);
	}
	
	@Override
    @Transactional
	public List<ElectronExpressVo> list(ElectronExpressVo electronExpressVo){
		return electronExpressDao.list(electronExpressVo);
	}
	
	@Override
    @Transactional
	public long count(ElectronExpressVo electronExpressVo){
		return electronExpressDao.count(electronExpressVo);
	}
	
	@Override
    @Transactional
	public int save(ElectronExpressVo electronExpress){
	    electronExpress.setId(sequenceId.nextId());
	    return electronExpressDao.save(electronExpress);
	}
	
	@Override
    @Transactional
	public int update(ElectronExpressVo electronExpress){
		return electronExpressDao.update(electronExpress);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return electronExpressDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return electronExpressDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<ElectronExpressVo> electronExpressList){
			electronExpressList.forEach(e -> e.setId(sequenceId.nextId()));
        return electronExpressDao.batchSave(electronExpressList);
    }
}
