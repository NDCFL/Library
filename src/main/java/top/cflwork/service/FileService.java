package top.cflwork.service;

import top.cflwork.vo.FileListVo;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-19 16:02:20
 */
public interface FileService {
	
	FileListVo get(String id);
	
	List<FileListVo> list(Map<String, Object> map);
	
	long count(Map<String, Object> map);
	
	int save(FileListVo sysFile);
	
	int update(FileListVo sysFile);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	/**
	 * 判断一个文件是否存在
	 * @param url FileListVo中存的路径
	 * @return
	 */
    Boolean isExist(String url);
}
