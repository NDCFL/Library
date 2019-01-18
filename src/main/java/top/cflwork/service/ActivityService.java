package top.cflwork.service;

import org.springframework.stereotype.Service;
import top.cflwork.vo.ActivityVo;

import java.util.List;
import java.util.Map;

/**
 * 活动管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-10 17:18:46
 */
@Service
public interface ActivityService {
	
	ActivityVo get(String id);
	
	List<ActivityVo> list(ActivityVo activityVo);
	
	long count(ActivityVo activityVo);
	
	int save(ActivityVo activity);
	
	int update(ActivityVo activity);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<ActivityVo> activityList);
}
