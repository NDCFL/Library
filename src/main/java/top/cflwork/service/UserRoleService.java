package top.cflwork.service;

import org.springframework.stereotype.Service;
import top.cflwork.vo.UserRoleVo;

import java.util.List;
import java.util.Map;

@Service
public interface UserRoleService {
    UserRoleVo get(String id);

    List<UserRoleVo> list(Map<String, Object> map);

    long count(Map<String, Object> map);

    int save(UserRoleVo userRole);

    int update(UserRoleVo userRole);

    int remove(String id);

    int batchRemove(String[] ids);

    List<String> listRoleId(String userId);

    int removeByUserId(String userId);

    int removeByRoleId(String roleId);

    int batchSave(List<UserRoleVo> list);

    int batchRemoveByUserId(String[] ids);
}
