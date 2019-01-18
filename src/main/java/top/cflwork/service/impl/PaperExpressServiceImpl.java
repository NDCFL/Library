package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.PaperExpressDao;
import top.cflwork.vo.PaperExpressVo;
import top.cflwork.service.PaperExpressService;
import top.cflwork.common.SequenceId;


@Service
public class PaperExpressServiceImpl implements PaperExpressService {
	@Autowired
	private PaperExpressDao paperExpressDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public PaperExpressVo get(String id){
		return paperExpressDao.get(id);
	}
	
	@Override
    @Transactional
	public List<PaperExpressVo> list(PaperExpressVo paperExpressVo){
		return paperExpressDao.list(paperExpressVo);
	}
	
	@Override
    @Transactional
	public long count(PaperExpressVo paperExpressVo){
		return paperExpressDao.count(paperExpressVo);
	}
	
	@Override
    @Transactional
	public int save(PaperExpressVo paperExpress){
	    paperExpress.setId(sequenceId.nextId());
	    return paperExpressDao.save(paperExpress);
	}
	
	@Override
    @Transactional
	public int update(PaperExpressVo paperExpress){
		return paperExpressDao.update(paperExpress);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return paperExpressDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return paperExpressDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<PaperExpressVo> paperExpressList){
			paperExpressList.forEach(e -> e.setId(sequenceId.nextId()));
        return paperExpressDao.batchSave(paperExpressList);
    }
}
