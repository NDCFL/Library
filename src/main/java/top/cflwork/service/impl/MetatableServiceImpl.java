package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.MetatableDao;
import top.cflwork.vo.MetatableVo;
import top.cflwork.service.MetatableService;
import top.cflwork.common.SequenceId;
import top.cflwork.vo.xmlvo.BookSearchVo;
import top.cflwork.vo.xmlvo.MetaTablesVo;


@Service
public class MetatableServiceImpl implements MetatableService {
	@Autowired
	private MetatableDao metatableDao;
	@Autowired
	private SequenceId sequenceId;
	@Override
	@Transactional
	public MetatableVo get(String id){
		return metatableDao.get(id);
	}

	@Override
	@Transactional
	public List<MetatableVo> list(MetatableVo metatableVo){
		return metatableDao.list(metatableVo);
	}

	@Override
	@Transactional
	public long count(MetatableVo metatableVo){
		return metatableDao.count(metatableVo);
	}

	@Override
	@Transactional
	public int save(MetatableVo metatable){
		metatable.setId(sequenceId.nextId());
		return metatableDao.save(metatable);
	}

	@Override
	@Transactional
	public int update(MetatableVo metatable){
		return metatableDao.update(metatable);
	}

	@Override
	@Transactional
	public int remove(String id){
		return metatableDao.remove(id);
	}

	@Override
	@Transactional
	public int batchRemove(String[] ids){
		return metatableDao.batchRemove(ids);
	}

	@Override
	@Transactional
	public int batchSave(List<MetatableVo> metatableList){
		metatableList.forEach(e -> e.setId(sequenceId.nextId()));
		return metatableDao.batchSave(metatableList);
	}

	@Override
	@Transactional
	public int batchSaveBook(BookSearchVo bookSearchVo){
		bookSearchVo.setId(sequenceId.nextId());
		return metatableDao.batchSaveBook(bookSearchVo);
	}

	@Override
	public int updateBook(MetaTablesVo metaTablesVo) {
		return metatableDao.updateBook(metaTablesVo);
	}
}
