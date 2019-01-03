package top.cflwork.service;


import top.cflwork.domain.ContentVo;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-09 10:03:34
 */
public interface ContentService {
	
	ContentVo get(Long cid);
	
	List<ContentVo> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ContentVo bContent);
	
	int update(ContentVo bContent);
	
	int remove(Long cid);
	
	int batchRemove(Long[] cids);
}
