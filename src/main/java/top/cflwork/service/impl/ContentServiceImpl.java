package top.cflwork.service.impl;

import top.cflwork.dao.ContentDao;
import top.cflwork.domain.ContentVo;
import top.cflwork.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentDao bContentMapper;
	
	@Override
	public ContentVo get(Long cid){
		return bContentMapper.get(cid);
	}
	
	@Override
	public List<ContentVo> list(Map<String, Object> map){
		return bContentMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bContentMapper.count(map);
	}
	
	@Override
	public int save(ContentVo bContent){
		return bContentMapper.save(bContent);
	}
	
	@Override
	public int update(ContentVo bContent){
		return bContentMapper.update(bContent);
	}
	
	@Override
	public int remove(Long cid){
		return bContentMapper.remove(cid);
	}
	
	@Override
	public int batchRemove(Long[] cids){
		return bContentMapper.batchRemove(cids);
	}
	
}
