package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.SpaceUseDao;
import top.cflwork.vo.SpaceUseVo;
import top.cflwork.service.SpaceUseService;
import top.cflwork.common.SequenceId;


@Service
public class SpaceUseServiceImpl implements SpaceUseService {
	@Autowired
	private SpaceUseDao spaceUseDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public SpaceUseVo get(String id){
		return spaceUseDao.get(id);
	}
	
	@Override
    @Transactional
	public List<SpaceUseVo> list(SpaceUseVo spaceUseVo){
		return spaceUseDao.list(spaceUseVo);
	}
	
	@Override
    @Transactional
	public long count(SpaceUseVo spaceUseVo){
		return spaceUseDao.count(spaceUseVo);
	}
	
	@Override
    @Transactional
	public int save(SpaceUseVo spaceUse){
	    spaceUse.setId(sequenceId.nextId());
	    return spaceUseDao.save(spaceUse);
	}
	
	@Override
    @Transactional
	public int update(SpaceUseVo spaceUse){
		return spaceUseDao.update(spaceUse);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return spaceUseDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return spaceUseDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<SpaceUseVo> spaceUseList){
			spaceUseList.forEach(e -> e.setId(sequenceId.nextId()));
        return spaceUseDao.batchSave(spaceUseList);
    }
}
