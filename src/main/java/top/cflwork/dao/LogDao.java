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

	LogVo get(LogVo logVo);
	
	List<LogVo> list(LogVo logVo);

	long count(LogVo logVo);
	
	int save(LogVo logVo);
	
	int update(LogVo logVo);
	
	int remove(String id);
	
	int batchRemove(String ids[]);
}
