package top.cflwork.dao;

import top.cflwork.vo.ElectronExpressVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 电子书的传递
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 17:57:32
 */
@Mapper
public interface ElectronExpressDao {

	ElectronExpressVo get(String id);
	
	List<ElectronExpressVo> list(ElectronExpressVo electronExpressVo);
	
	long count(ElectronExpressVo electronExpressVo);
	
	int save(ElectronExpressVo electronExpress);
	
	int update(ElectronExpressVo electronExpress);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<ElectronExpressVo> electronExpressList);
}
