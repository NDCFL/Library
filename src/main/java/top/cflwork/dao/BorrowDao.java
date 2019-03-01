package top.cflwork.dao;

import top.cflwork.vo.BorrowVo;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
/**
 * 借阅记录管理
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-01 17:27:02
 */
@Mapper
public interface BorrowDao {

	BorrowVo get(String id);
	
	List<BorrowVo> list(BorrowVo borrowVo);
	
	long count(BorrowVo borrowVo);
	
	int save(BorrowVo borrow);
	
	int update(BorrowVo borrow);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	int batchSave(List<BorrowVo> borrowList);
}
