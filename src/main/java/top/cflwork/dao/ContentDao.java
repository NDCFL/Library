package top.cflwork.dao;

import top.cflwork.domain.ContentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 16:17:48
 */
@Mapper
public interface ContentDao {

	ContentVo get(Long cid);
	
	List<ContentVo> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(ContentVo content);
	
	int update(ContentVo content);
	
	int remove(Long cid);
	
	int batchRemove(Long[] cids);
}
