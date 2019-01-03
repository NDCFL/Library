package top.cflwork.service.impl;

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
	LogDao logMapper;

	@Async
	@Override
	public void save(LogVo logDO) {
		 logMapper.save(logDO);
	}

	@Override
	public PageVo<LogVo> queryList(Query query) {
		int total = logMapper.count(query);
		List<LogVo> logs = logMapper.list(query);
		PageVo<LogVo> page = new PageVo<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	@Override
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(Long[] ids){
		return logMapper.batchRemove(ids);
	}
}
