package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.IntegralTypeDao;
import top.cflwork.vo.IntegralTypeVo;
import top.cflwork.service.IntegralTypeService;
import top.cflwork.common.SequenceId;


@Service
public class IntegralTypeServiceImpl implements IntegralTypeService {
	@Autowired
	private IntegralTypeDao integralTypeDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public IntegralTypeVo get(String id){
		return integralTypeDao.get(id);
	}
	
	@Override
    @Transactional
	public List<IntegralTypeVo> list(IntegralTypeVo integralTypeVo){
		return integralTypeDao.list(integralTypeVo);
	}
	
	@Override
    @Transactional
	public long count(IntegralTypeVo integralTypeVo){
		return integralTypeDao.count(integralTypeVo);
	}
	
	@Override
    @Transactional
	public int save(IntegralTypeVo integralType){
	    integralType.setId(sequenceId.nextId());
	    return integralTypeDao.save(integralType);
	}
	
	@Override
    @Transactional
	public int update(IntegralTypeVo integralType){
		return integralTypeDao.update(integralType);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return integralTypeDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return integralTypeDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<IntegralTypeVo> integralTypeList){
			integralTypeList.forEach(e -> e.setId(sequenceId.nextId()));
        return integralTypeDao.batchSave(integralTypeList);
    }
}
