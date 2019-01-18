package top.cflwork.service;

import top.cflwork.vo.SpaceUseVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 预约场地管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 15:39:21
 */
@Service
public interface SpaceUseService {
	
	SpaceUseVo get(String id);
	
	List<SpaceUseVo> list(SpaceUseVo spaceUseVo);
	
	long count(SpaceUseVo spaceUseVo);
	
	int save(SpaceUseVo spaceUse);
	
	int update(SpaceUseVo spaceUse);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<SpaceUseVo> spaceUseList);
}
