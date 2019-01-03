package top.cflwork.dao;

import top.cflwork.domain.UserVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 09:45:11
 */
@Mapper
public interface UserDao {

	UserVo get(Long userId);
	
	List<UserVo> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserVo user);
	
	int update(UserVo user);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);
	
	Long[] listAllDept();

}
