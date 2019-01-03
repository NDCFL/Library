package top.cflwork.service;

import top.cflwork.vo.LogVo;
import top.cflwork.vo.PageVo;
import top.cflwork.util.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	void save(LogVo logDO);
	PageVo<LogVo> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
