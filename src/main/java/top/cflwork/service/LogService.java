package top.cflwork.service;

import top.cflwork.common.annotation.Log;
import top.cflwork.util.PageUtils;
import top.cflwork.vo.LogVo;
import top.cflwork.vo.PageVo;
import top.cflwork.util.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
	LogVo get(LogVo logVo);

	List<LogVo> list(LogVo logVo);

	long count(LogVo logVo);

	int save(LogVo log);

	int update(LogVo log);

	int remove(String id);

	int batchRemove(String ids[]);
}
