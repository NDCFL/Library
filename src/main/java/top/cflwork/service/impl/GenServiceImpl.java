package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.GenDao;
import top.cflwork.vo.GenVo;
import top.cflwork.service.GenService;
import top.cflwork.common.SequenceId;


@Service
public class GenServiceImpl implements GenService {
	@Autowired
	private GenDao genDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public GenVo get(String id){
		return genDao.get(id);
	}
	
	@Override
    @Transactional
	public List<GenVo> list(GenVo genVo){
		return genDao.list(genVo);
	}
	
	@Override
    @Transactional
	public long count(GenVo genVo){
		return genDao.count(genVo);
	}
	
	@Override
    @Transactional
	public int save(GenVo gen){
	    gen.setId(sequenceId.nextId());
	    return genDao.save(gen);
	}
	
	@Override
    @Transactional
	public int update(GenVo gen){
		return genDao.update(gen);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return genDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return genDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<GenVo> genList){
			genList.forEach(e -> e.setId(sequenceId.nextId()));
        return genDao.batchSave(genList);
    }
}
