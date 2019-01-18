package top.cflwork.service;

import top.cflwork.vo.SpaceVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 场地管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 14:58:55
 */
@Service
public interface SpaceService {
	
	SpaceVo get(String id);
	
	List<SpaceVo> list(SpaceVo spaceVo);
	
	long count(SpaceVo spaceVo);
	
	int save(SpaceVo space);
	
	int update(SpaceVo space);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<SpaceVo> spaceList);
}
