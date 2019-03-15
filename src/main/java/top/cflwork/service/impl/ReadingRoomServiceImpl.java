package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.ReadingRoomDao;
import top.cflwork.vo.ReadingRoomVo;
import top.cflwork.service.ReadingRoomService;
import top.cflwork.common.SequenceId;
import top.cflwork.vo.Select2Vo;


@Service
public class ReadingRoomServiceImpl implements ReadingRoomService {
	@Autowired
	private ReadingRoomDao readingRoomDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public ReadingRoomVo get(String id){
		return readingRoomDao.get(id);
	}
	
	@Override
    @Transactional
	public List<ReadingRoomVo> list(ReadingRoomVo readingRoomVo){
		return readingRoomDao.list(readingRoomVo);
	}
	
	@Override
    @Transactional
	public long count(ReadingRoomVo readingRoomVo){
		return readingRoomDao.count(readingRoomVo);
	}
	
	@Override
    @Transactional
	public int save(ReadingRoomVo readingRoom){
	    readingRoom.setId(sequenceId.nextId());
	    return readingRoomDao.save(readingRoom);
	}
	
	@Override
    @Transactional
	public int update(ReadingRoomVo readingRoom){
		return readingRoomDao.update(readingRoom);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return readingRoomDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return readingRoomDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<ReadingRoomVo> readingRoomList){
			readingRoomList.forEach(e -> e.setId(sequenceId.nextId()));
        return readingRoomDao.batchSave(readingRoomList);
    }

	@Override
	public List<Select2Vo> getReaddingRoom() {
		return readingRoomDao.getReaddingRoom();
	}
}
