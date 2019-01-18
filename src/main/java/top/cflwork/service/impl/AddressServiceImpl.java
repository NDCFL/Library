package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import top.cflwork.dao.AddressDao;
import top.cflwork.vo.AddressVo;
import top.cflwork.service.AddressService;
import top.cflwork.common.SequenceId;


@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;
    @Autowired
    private SequenceId sequenceId;
	@Override
    @Transactional
	public AddressVo get(String id){
		return addressDao.get(id);
	}
	
	@Override
    @Transactional
	public List<AddressVo> list(AddressVo addressVo){
		return addressDao.list(addressVo);
	}
	
	@Override
    @Transactional
	public long count(AddressVo addressVo){
		return addressDao.count(addressVo);
	}
	
	@Override
    @Transactional
	public int save(AddressVo address){
	    address.setId(sequenceId.nextId());
	    return addressDao.save(address);
	}
	
	@Override
    @Transactional
	public int update(AddressVo address){
		return addressDao.update(address);
	}
	
	@Override
    @Transactional
	public int remove(String id){
		return addressDao.remove(id);
	}
	
	@Override
    @Transactional
	public int batchRemove(String[] ids){
		return addressDao.batchRemove(ids);
	}

    @Override
    @Transactional
    public int batchSave(List<AddressVo> addressList){
			addressList.forEach(e -> e.setId(sequenceId.nextId()));
        return addressDao.batchSave(addressList);
    }
}
