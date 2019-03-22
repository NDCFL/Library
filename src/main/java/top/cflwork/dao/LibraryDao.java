package top.cflwork.dao;

import org.apache.ibatis.annotations.Mapper;
import top.cflwork.vo.LibraryVo;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 15:35:39
 */
@Mapper
public interface LibraryDao {

	LibraryVo get(String libraryId);
	
	List<LibraryVo> list(Map<String, Object> map);
	
	long count(Map<String, Object> map);
	
	int save(LibraryVo library);
	
	int update(LibraryVo library);
	
	int remove(String libraryId);
	
	int batchRemove(String[] libraryIds);
	
	String[] listParentLibrary();
	
	int getLibraryUserNumber(String libraryId);
}
