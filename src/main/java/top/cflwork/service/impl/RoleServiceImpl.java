package top.cflwork.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.cflwork.dao.RoleDao;
import top.cflwork.dao.RoleMenuDao;
import top.cflwork.dao.UserDao;
import top.cflwork.dao.UserRoleDao;
import top.cflwork.vo.RoleVo;
import top.cflwork.vo.RoleMenuVo;
import top.cflwork.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

    public static final String ROLE_ALL_KEY = "\"role_all\"";

    public static final String DEMO_CACHE_NAME = "role";

    @Autowired
    RoleDao roleMapper;
    @Autowired
    RoleMenuDao roleMenuMapper;
    @Autowired
    UserDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;

    @Override
    public List<RoleVo> list() {
        List<RoleVo> roles = roleMapper.list(new HashMap<>(16));
        return roles;
    }


    @Override
    public List<RoleVo> list(String userId) {
        List<String> rolesIds = userRoleMapper.listRoleId(userId);
        List<RoleVo> roles = roleMapper.list(new HashMap<>(16));
        for (RoleVo roleVo : roles) {
            roleVo.setRoleSign("false");
            for (String roleId : rolesIds) {
                if (Objects.equals(roleVo.getRoleId(), roleId)) {
                    roleVo.setRoleSign("true");
                    break;
                }
            }
        }
        return roles;
    }
    @Transactional
    @Override
    public int save(RoleVo role) {
        int count = roleMapper.save(role);
        List<String> menuIds = role.getMenuIds();
        String roleId = role.getRoleId();
        List<RoleMenuVo> rms = new ArrayList<>();
        for (String menuId : menuIds) {
            RoleMenuVo rmDo = new RoleMenuVo();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rms.add(rmDo);
        }
        roleMenuMapper.removeByRoleId(roleId);
        if (rms.size() > 0) {
            roleMenuMapper.batchSave(rms);
        }
        return count;
    }

    @Transactional
    @Override
    public int remove(String id) {
        int count = roleMapper.remove(id);
        userRoleMapper.removeByRoleId(id);
        roleMenuMapper.removeByRoleId(id);
        return count;
    }

    @Override
    public RoleVo get(String id) {
        RoleVo roleVo = roleMapper.get(id);
        return roleVo;
    }

    @Override
    public int update(RoleVo role) {
        int r = roleMapper.update(role);
        List<String> menuIds = role.getMenuIds();
        String roleId = role.getRoleId();
        roleMenuMapper.removeByRoleId(roleId);
        List<RoleMenuVo> rms = new ArrayList<>();
        for (String menuId : menuIds) {
            RoleMenuVo rmDo = new RoleMenuVo();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            rms.add(rmDo);
        }
        if (rms.size() > 0) {
            roleMenuMapper.batchSave(rms);
        }
        return r;
    }

    @Override
    public int batchremove(String[] ids) {
        int r = roleMapper.batchRemove(ids);
        return r;
    }

}
