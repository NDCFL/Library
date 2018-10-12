package com.library.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.common.domain.LogDO;
import com.library.common.domain.PageDO;
import com.library.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
