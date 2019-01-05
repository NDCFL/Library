package top.cflwork.service;

import top.cflwork.vo.NotifyVo;
import top.cflwork.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 通知通告
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-05 17:11:16
 */
public interface NotifyService {

	NotifyVo get(Long id);

	List<NotifyVo> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(NotifyVo notify);

	int update(NotifyVo notify);

	int remove(Long id);

	int batchRemove(Long[] ids);

//	Map<String, Object> message(Long userId);

	PageUtils selfList(Map<String, Object> map);
}
