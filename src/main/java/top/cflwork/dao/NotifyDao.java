package top.cflwork.dao;

import org.apache.ibatis.annotations.Mapper;
import top.cflwork.vo.NotifyVo;
import top.cflwork.vo.NotifyDTO;

import java.util.List;
import java.util.Map;

/**
 * 通知通告
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-05 17:11:16
 */
@Mapper
public interface NotifyDao {

	NotifyVo get(String id);

	List<NotifyVo> list(NotifyVo notifyVo);

	long count(NotifyVo notifyVo);

	int save(NotifyVo notify);

	int update(NotifyVo notify);

	int remove(String id);

	int batchRemove(String[] ids);

	List<NotifyVo> listByIds(String[] ids);

	long countDTO(Map<String, Object> map);

	List<NotifyDTO> listDTO(Map<String, Object> map);
}
