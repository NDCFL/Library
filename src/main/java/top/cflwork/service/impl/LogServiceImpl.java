package top.cflwork.service.impl;

import top.cflwork.common.SequenceId;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.dao.LogDao;
import top.cflwork.service.LogService;
import top.cflwork.vo.LogVo;
import top.cflwork.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	public LogDao logDao;
	@Autowired
	private SequenceId sequenceId;

	@Override
	public LogVo get(LogVo logVo) {
		return logDao.get(logVo);
	}

	@Override
	public List<LogVo> list(LogVo logVo) {
		return logDao.list(logVo);
	}

	@Override
	public long count(LogVo logVo) {
		return logDao.count(logVo);
	}

	@Override
	public int save(LogVo logVo) {
		logVo.setId(sequenceId.nextId());
		return logDao.save(logVo);
	}

	@Override
	public int update(LogVo logVo) {
		return logDao.update(logVo);
	}

	@Override
	public int remove(String id) {
		return logDao.remove(id);
	}

	@Override
	public int batchRemove(String ids[]) {
		return logDao.batchRemove(ids);
	}
}
