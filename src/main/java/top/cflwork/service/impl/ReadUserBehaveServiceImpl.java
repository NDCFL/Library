package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.ReadUserBehaveDao;
import top.cflwork.vo.ReadUserBehaveVo;
import top.cflwork.service.ReadUserBehaveService;
import top.cflwork.common.SequenceId;


@Service
public class ReadUserBehaveServiceImpl implements ReadUserBehaveService {
	@Autowired
	private ReadUserBehaveDao readUserBehaveDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public ReadUserBehaveVo get(String id){
		return readUserBehaveDao.get(id);
	}
	
	@Override
    @Transactional
	public List<ReadUserBehaveVo> list(ReadUserBehaveVo readUserBehaveVo){
		return readUserBehaveDao.list(readUserBehaveVo);
	}
	
	@Override
    @Transactional
	public long count(ReadUserBehaveVo readUserBehaveVo){
		return readUserBehaveDao.count(readUserBehaveVo);
	}
	
	@Override
    @Transactional
	public int save(ReadUserBehaveVo readUserBehave){
	    readUserBehave.setId(sequenceId.nextId());
	    return readUserBehaveDao.save(readUserBehave);
	}
	
	@Override
    @Transactional
	public int update(ReadUserBehaveVo readUserBehave){
		return readUserBehaveDao.update(readUserBehave);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return readUserBehaveDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return readUserBehaveDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<ReadUserBehaveVo> readUserBehaveList){
			readUserBehaveList.forEach(e -> e.setId(sequenceId.nextId()));
        return readUserBehaveDao.batchSave(readUserBehaveList);
    }
}
