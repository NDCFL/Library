package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.SpaceDao;
import top.cflwork.vo.SpaceVo;
import top.cflwork.service.SpaceService;
import top.cflwork.common.SequenceId;


@Service
public class SpaceServiceImpl implements SpaceService {
	@Autowired
	private SpaceDao spaceDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public SpaceVo get(String id){
		return spaceDao.get(id);
	}
	
	@Override
    @Transactional
	public List<SpaceVo> list(SpaceVo spaceVo){
		return spaceDao.list(spaceVo);
	}
	
	@Override
    @Transactional
	public long count(SpaceVo spaceVo){
		return spaceDao.count(spaceVo);
	}
	
	@Override
    @Transactional
	public int save(SpaceVo space){
	    space.setId(sequenceId.nextId());
	    return spaceDao.save(space);
	}
	
	@Override
    @Transactional
	public int update(SpaceVo space){
		return spaceDao.update(space);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return spaceDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return spaceDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<SpaceVo> spaceList){
			spaceList.forEach(e -> e.setId(sequenceId.nextId()));
        return spaceDao.batchSave(spaceList);
    }
}
