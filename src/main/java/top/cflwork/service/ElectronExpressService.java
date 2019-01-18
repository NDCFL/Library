package top.cflwork.service;

import top.cflwork.vo.ElectronExpressVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 电子书的传递
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 17:57:32
 */
@Service
public interface ElectronExpressService {
	
	ElectronExpressVo get(String id);
	
	List<ElectronExpressVo> list(ElectronExpressVo electronExpressVo);
	
	long count(ElectronExpressVo electronExpressVo);
	
	int save(ElectronExpressVo electronExpress);
	
	int update(ElectronExpressVo electronExpress);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<ElectronExpressVo> electronExpressList);
}
