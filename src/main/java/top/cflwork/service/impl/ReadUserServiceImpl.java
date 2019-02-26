package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.ReadUserDao;
import top.cflwork.vo.ReadUserVo;
import top.cflwork.service.ReadUserService;
import top.cflwork.common.SequenceId;


@Service
public class ReadUserServiceImpl implements ReadUserService {
	@Autowired
	private ReadUserDao readUserDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public ReadUserVo get(String id){
		return readUserDao.get(id);
	}
	
	@Override
    @Transactional
	public List<ReadUserVo> list(ReadUserVo readUserVo){
		return readUserDao.list(readUserVo);
	}
	
	@Override
    @Transactional
	public long count(ReadUserVo readUserVo){
		return readUserDao.count(readUserVo);
	}
	
	@Override
    @Transactional
	public int save(ReadUserVo readUser){
	    readUser.setId(sequenceId.nextId());
	    return readUserDao.save(readUser);
	}
	
	@Override
    @Transactional
	public int update(ReadUserVo readUser){
		return readUserDao.update(readUser);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return readUserDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return readUserDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<ReadUserVo> readUserList){
			readUserList.forEach(e -> e.setId(sequenceId.nextId()));
        return readUserDao.batchSave(readUserList);
    }

	@Override
	public ReadUserVo getReadUser(ReadUserVo readUserVo) {
		return readUserDao.getReadUser(readUserVo);
	}
}
