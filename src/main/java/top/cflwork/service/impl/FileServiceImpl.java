package top.cflwork.service.impl;

import top.cflwork.config.CflworksConfig;
import top.cflwork.service.FileService;
import top.cflwork.dao.FileDao;
import top.cflwork.vo.FileListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Map;


@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao sysFileMapper;

	@Autowired
	private CflworksConfig cflworksConfig;
	@Override
	public FileListVo get(String id){
		return sysFileMapper.get(id);
	}
	
	@Override
	public List<FileListVo> list(Map<String, Object> map){
		return sysFileMapper.list(map);
	}
	
	@Override
	public long count(Map<String, Object> map){
		return sysFileMapper.count(map);
	}
	
	@Override
	public int save(FileListVo sysFile){
		return sysFileMapper.save(sysFile);
	}
	
	@Override
	public int update(FileListVo sysFile){
		return sysFileMapper.update(sysFile);
	}
	
	@Override
	public int remove(String id){
		return sysFileMapper.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return sysFileMapper.batchRemove(ids);
	}

    @Override
    public Boolean isExist(String url) {
		Boolean isExist = false;
		if (!StringUtils.isEmpty(url)) {
			String filePath = url.replace("/files/", "");
			filePath = cflworksConfig.getUploadPath() + filePath;
			File file = new File(filePath);
			if (file.exists()) {
				isExist = true;
			}
		}
		return isExist;
	}
	}
