package top.cflwork.dao;

import top.cflwork.domain.NotifyRecordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 通知通告发送记录
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-09 17:18:45
 */
@Mapper
public interface NotifyRecordDao {

	NotifyRecordVo get(Long id);

	List<NotifyRecordVo> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(NotifyRecordVo notifyRecord);

	int update(NotifyRecordVo notifyRecord);

	int remove(Long id);

	int batchRemove(Long[] ids);

	int batchSave(List<NotifyRecordVo> records);

	Long[] listNotifyIds(Map<String, Object> map);

	int removeByNotifbyId(Long notifyId);

	int batchRemoveByNotifbyId(Long[] notifyIds);

	int changeRead(NotifyRecordVo notifyRecord);
}
