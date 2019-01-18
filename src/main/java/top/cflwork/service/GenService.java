package top.cflwork.service;

import top.cflwork.vo.GenVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 情报管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 18:10:40
 */
@Service
public interface GenService {
	
	GenVo get(String id);
	
	List<GenVo> list(GenVo genVo);
	
	long count(GenVo genVo);
	
	int save(GenVo gen);
	
	int update(GenVo gen);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<GenVo> genList);
}
