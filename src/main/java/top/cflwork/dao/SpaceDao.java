package top.cflwork.dao;

import top.cflwork.vo.SpaceVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 场地管理
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 14:58:55
 */
@Mapper
public interface SpaceDao {

	SpaceVo get(String id);
	
	List<SpaceVo> list(SpaceVo spaceVo);
	
	long count(SpaceVo spaceVo);
	
	int save(SpaceVo space);
	
	int update(SpaceVo space);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<SpaceVo> spaceList);
}
