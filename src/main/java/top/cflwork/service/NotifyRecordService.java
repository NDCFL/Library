package top.cflwork.service;

import top.cflwork.domain.NotifyRecordVo;

import java.util.List;
import java.util.Map;

/**
 * 通知通告发送记录
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-09 17:18:45
 */
public interface NotifyRecordService {
	
	NotifyRecordVo get(Long id);
	
	List<NotifyRecordVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NotifyRecordVo notifyRecord);
	
	int update(NotifyRecordVo notifyRecord);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	/**
	 * 更改阅读状态
	 * @return
	 */
	int changeRead(NotifyRecordVo notifyRecord);
}
