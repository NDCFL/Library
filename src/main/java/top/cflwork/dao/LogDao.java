package top.cflwork.dao;

import top.cflwork.vo.LogVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface LogDao {

	LogVo get(Long id);
	
	List<LogVo> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(LogVo log);
	
	int update(LogVo log);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
