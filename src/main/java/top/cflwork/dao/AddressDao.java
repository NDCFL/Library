package top.cflwork.dao;

import top.cflwork.vo.AddressVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 存储读者的地址
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 14:55:55
 */
@Mapper
public interface AddressDao {

	AddressVo get(String id);
	
	List<AddressVo> list(AddressVo addressVo);
	
	long count(AddressVo addressVo);
	
	int save(AddressVo address);
	
	int update(AddressVo address);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<AddressVo> addressList);
}
