package top.cflwork.dao;

import top.cflwork.vo.UserVo;

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

	UserVo get(String userId);
	
	List<UserVo> list(Map<String,Object> map);
	
	long count(Map<String,Object> map);
	
	int save(UserVo user);
	
	int update(UserVo user);
	
	int remove(String userId);
	
	int batchRemove(String[] userIds);
	
	Long[] listAllDept();

	int updateFaceImg(UserVo userVo);

}
