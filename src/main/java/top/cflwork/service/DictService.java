package top.cflwork.service;

import top.cflwork.vo.UserVo;
import top.cflwork.vo.DictVo;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-29 18:28:07
 */
public interface DictService {
	
	DictVo get(String id);
	
	List<DictVo> list(Map<String, Object> map);
	
	long count(Map<String, Object> map);
	
	int save(DictVo dict);
	
	int update(DictVo dict);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<DictVo> listType();
	
	String getName(String type, String value);

	/**
	 * 获取爱好列表
	 * @return
     * @param userVo
	 */
	List<DictVo> getHobbyList(UserVo userVo);

	/**
	 * 获取性别列表
 	 * @return
	 */
	List<DictVo> getSexList();

	/**
	 * 根据type获取数据
	 * @param
	 * @return
	 */
	List<DictVo> listByType(String type);

}
