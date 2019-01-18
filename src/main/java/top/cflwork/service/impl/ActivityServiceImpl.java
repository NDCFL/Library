package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.ActivityDao;
import top.cflwork.vo.ActivityVo;
import top.cflwork.service.ActivityService;
import top.cflwork.common.SequenceId;


@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityDao activityDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public ActivityVo get(String id){
		return activityDao.get(id);
	}
	
	@Override
    @Transactional
	public List<ActivityVo> list(ActivityVo activityVo){
		return activityDao.list(activityVo);
	}
	
	@Override
    @Transactional
	public long count(ActivityVo activityVo){
		return activityDao.count(activityVo);
	}
	
	@Override
    @Transactional
	public int save(ActivityVo activity){
	    activity.setId(sequenceId.nextId());
	    return activityDao.save(activity);
	}
	
	@Override
    @Transactional
	public int update(ActivityVo activity){
		return activityDao.update(activity);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return activityDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return activityDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<ActivityVo> activityList){
			activityList.forEach(e -> e.setId(sequenceId.nextId()));
        return activityDao.batchSave(activityList);
    }
}
