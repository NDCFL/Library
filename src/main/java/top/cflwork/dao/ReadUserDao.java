package top.cflwork.dao;

import top.cflwork.vo.ReadUserVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 读者管理
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 10:31:43
 */
@Mapper
public interface ReadUserDao {

	ReadUserVo get(String id);
	
	List<ReadUserVo> list(ReadUserVo readUserVo);
	
	long count(ReadUserVo readUserVo);
	
	int save(ReadUserVo readUser);
	
	int update(ReadUserVo readUser);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<ReadUserVo> readUserList);
}
