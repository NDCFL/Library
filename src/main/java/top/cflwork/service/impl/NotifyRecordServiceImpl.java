package top.cflwork.service.impl;

import top.cflwork.dao.NotifyRecordDao;
import top.cflwork.domain.NotifyRecordVo;
import top.cflwork.service.NotifyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class NotifyRecordServiceImpl implements NotifyRecordService {
	@Autowired
	private NotifyRecordDao notifyRecordDao;
	
	@Override
	public NotifyRecordVo get(Long id){
		return notifyRecordDao.get(id);
	}
	
	@Override
	public List<NotifyRecordVo> list(Map<String, Object> map){
		return notifyRecordDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return notifyRecordDao.count(map);
	}
	
	@Override
	public int save(NotifyRecordVo notifyRecord){
		return notifyRecordDao.save(notifyRecord);
	}
	
	@Override
	public int update(NotifyRecordVo notifyRecord){
		return notifyRecordDao.update(notifyRecord);
	}
	
	@Override
	public int remove(Long id){
		return notifyRecordDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return notifyRecordDao.batchRemove(ids);
	}

	@Override
	public int changeRead(NotifyRecordVo notifyRecord) {
		return notifyRecordDao.changeRead(notifyRecord);
	}

}
