package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cflwork.common.SequenceId;
import top.cflwork.dao.NotifyRecordDao;
import top.cflwork.vo.NotifyRecordVo;
import top.cflwork.service.NotifyRecordService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class NotifyRecordServiceImpl implements NotifyRecordService {
	@Autowired
	private NotifyRecordDao notifyRecordDao;
	@Resource
	private SequenceId sequenceId;
	@Override
	public NotifyRecordVo get(String id){
		return notifyRecordDao.get(id);
	}
	
	@Override
	public List<NotifyRecordVo> list(Map<String, Object> map){
		return notifyRecordDao.list(map);
	}
	
	@Override
	public long count(Map<String, Object> map){
		return notifyRecordDao.count(map);
	}
	
	@Override
	public int save(NotifyRecordVo notifyRecord){
		notifyRecord.setId(sequenceId.nextId());
		return notifyRecordDao.save(notifyRecord);
	}
	
	@Override
	public int update(NotifyRecordVo notifyRecord){
		return notifyRecordDao.update(notifyRecord);
	}
	
	@Override
	public int remove(String id){
		return notifyRecordDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return notifyRecordDao.batchRemove(ids);
	}

	@Override
	public int changeRead(NotifyRecordVo notifyRecord) {
		return notifyRecordDao.changeRead(notifyRecord);
	}

}
