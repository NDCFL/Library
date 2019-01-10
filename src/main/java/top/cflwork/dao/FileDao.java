package top.cflwork.dao;

import top.cflwork.vo.FileListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface FileDao {

	FileListVo get(String id);
	
	List<FileListVo> list(Map<String, Object> map);

	long count(Map<String, Object> map);
	
	int save(FileListVo file);
	
	int update(FileListVo file);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
