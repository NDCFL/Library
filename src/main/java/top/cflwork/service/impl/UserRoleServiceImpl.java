package top.cflwork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cflwork.common.SequenceId;
import top.cflwork.dao.UserRoleDao;
import top.cflwork.service.UserRoleService;
import top.cflwork.vo.UserRoleVo;

import java.util.List;
import java.util.Map;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private SequenceId sequenceId;
    @Override
    public UserRoleVo get(String id) {
        return userRoleDao.get(id);
    }

    @Override
    public List<UserRoleVo> list(Map<String, Object> map) {
        return userRoleDao.list(map);
    }

    @Override
    public long count(Map<String, Object> map) {
        return userRoleDao.count(map);
    }

    @Override
    public int save(UserRoleVo userRole) {
        userRole.setId(sequenceId.nextId());
        return userRoleDao.save(userRole);
    }

    @Override
    public int update(UserRoleVo userRole) {
        return userRoleDao.update(userRole);
    }

    @Override
    public int remove(String id) {
        return userRoleDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids) {
        return userRoleDao.batchRemove(ids);
    }

    @Override
    public List<String> listRoleId(String userId) {
        return userRoleDao.listRoleId(userId);
    }

    @Override
    public int removeByUserId(String userId) {
        return userRoleDao.removeByUserId(userId);
    }

    @Override
    public int removeByRoleId(String roleId) {
        return userRoleDao.removeByRoleId(roleId);
    }

    @Override
    public int batchSave(List<UserRoleVo> list) {
        list.stream().forEach(e->{
            e.setId(sequenceId.nextId());
        });
        return userRoleDao.batchSave(list);
    }

    @Override
    public int batchRemoveByUserId(String[] ids) {
        return userRoleDao.batchRemoveByUserId(ids);
    }
}
