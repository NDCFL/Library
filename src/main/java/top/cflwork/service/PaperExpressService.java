package top.cflwork.service;

import top.cflwork.vo.PaperExpressVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 纸质书的传递
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 16:34:56
 */
@Service
public interface PaperExpressService {
	
	PaperExpressVo get(String id);
	
	List<PaperExpressVo> list(PaperExpressVo paperExpressVo);
	
	long count(PaperExpressVo paperExpressVo);
	
	int save(PaperExpressVo paperExpress);
	
	int update(PaperExpressVo paperExpress);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<PaperExpressVo> paperExpressList);
}
