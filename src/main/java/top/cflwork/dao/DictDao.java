package top.cflwork.dao;

import top.cflwork.vo.DictVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface DictDao {

	DictVo get(Long id);

	List<DictVo> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(DictVo dict);

	int update(DictVo dict);

	int remove(Long id);

	int batchRemove(Long[] ids);

	List<DictVo> listType();
}