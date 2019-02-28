package top.cflwork.service;

import top.cflwork.vo.ReadUserBehaveVo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * 读者的兴趣爱好
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-02-28 14:08:14
 */
@Service
public interface ReadUserBehaveService {
	
	ReadUserBehaveVo get(String id);
	
	List<ReadUserBehaveVo> list(ReadUserBehaveVo readUserBehaveVo);
	
	long count(ReadUserBehaveVo readUserBehaveVo);
	
	int save(ReadUserBehaveVo readUserBehave);
	
	int update(ReadUserBehaveVo readUserBehave);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

    int batchSave(List<ReadUserBehaveVo> readUserBehaveList);
}
