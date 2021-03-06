package top.cflwork.service.impl;

import top.cflwork.common.SequenceId;
import top.cflwork.config.CflworksConfig;
import top.cflwork.dao.LibraryDao;
import top.cflwork.service.UserRoleService;
import top.cflwork.util.*;
import top.cflwork.dao.DeptDao;
import top.cflwork.dao.UserDao;
import top.cflwork.dao.UserRoleDao;
import top.cflwork.vo.*;
import top.cflwork.service.FileService;
import top.cflwork.service.UserService;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.*;

//@CacheConfig(cacheNames = "user")
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    DeptDao deptDao;
    @Autowired
    private FileService sysFileService;
    @Autowired
    private CflworksConfig cflworksConfig;
    @Autowired
    private SequenceId sequenceId;
    @Autowired
    private LibraryDao libraryDao;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
//    @Cacheable(key = "#id")
    public UserVo get(String id) {
        List<String> roleIds = userRoleService.listRoleId(id);
        UserVo user = userDao.get(id);
        DeptVo deptVo = deptDao.get(user.getDeptId());
        LibraryVo libraryVo = libraryDao.get(user.getLibraryId());
        if(deptVo==null){
            user.setDeptName("无");
        }else{
            user.setDeptName(deptDao.get(user.getDeptId()).getName());
        }
        if(libraryVo==null){
            user.setLibraryName("无");
        }else{
            user.setLibraryName(libraryDao.get(user.getLibraryId()).getName());
        }
        user.setRoleIds(roleIds);
        return user;
    }

    @Override
    public List<UserVo> list(Map<String, Object> map) {
        return userDao.list(map);
    }

    @Override
    public long count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Transactional
    @Override
    public int save(UserVo user) {
        user.setUserId(sequenceId.nextId());
        int count = userDao.save(user);
        String userId = user.getUserId();
        List<String> roles = user.getRoleIds();
        userRoleService.removeByUserId(userId);
        List<UserRoleVo> list = new ArrayList<>();
        for (String roleId : roles) {
            UserRoleVo ur = new UserRoleVo();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleService.batchSave(list);
        }
        return count;
    }

    @Override
    public int update(UserVo user) {
        int r = userDao.update(user);
        String userId = user.getUserId();
        List<String> roles = user.getRoleIds();
        userRoleService.removeByUserId(userId);
        List<UserRoleVo> list = new ArrayList<>();
        for (String roleId : roles) {
            UserRoleVo ur = new UserRoleVo();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleService.batchSave(list);
        }
        return r;
    }

    @Override
    public int remove(String userId) {
        userRoleService.removeByUserId(userId);
        return userDao.remove(userId);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = userDao.list(params).size() > 0;
        return exit;
    }

    @Override
    public Set<String> listRoles(String userId) {
        return null;
    }

    @Override
    public int resetPwd(UserPwdVo userPwdVo, UserVo userVo) throws Exception {
        if (Objects.equals(userPwdVo.getUserVo().getUserId(), userVo.getUserId())) {
            if (Objects.equals(MD5Utils.encrypt(userVo.getUsername(), userPwdVo.getPwdOld()), userVo.getPassword())) {
                userVo.setPassword(MD5Utils.encrypt(userVo.getUsername(), userPwdVo.getPwdNew()));
                return userDao.update(userVo);
            } else {
                throw new Exception("输入的旧密码有误！");
            }
        } else {
            throw new Exception("你修改的不是你登录的账号！");
        }
    }

    @Override
    public int adminResetPwd(UserPwdVo userPwdVo) throws Exception {
        UserVo userVo = get(userPwdVo.getUserVo().getUserId());
        if ("admin".equals(userVo.getUsername())) {
            throw new Exception("超级管理员的账号不允许直接重置！");
        }
        userVo.setPassword(MD5Utils.encrypt(userVo.getUsername(), userPwdVo.getPwdNew()));
        return userDao.update(userVo);


    }

    @Transactional
    @Override
    public int batchremove(String[] userIds) {
        int count = userDao.batchRemove(userIds);
        userRoleService.batchRemoveByUserId(userIds);
        return count;
    }

    @Override
    public Tree<DeptVo> getTree() {
        List<Tree<DeptVo>> trees = new ArrayList<Tree<DeptVo>>();
        List<DeptVo> depts = deptDao.list(new HashMap<String, Object>(16));
        String[] pDepts = deptDao.listParentDept();
        String[] uDepts = userDao.listAllDept();
        String[] allDepts = (String[]) ArrayUtils.addAll(pDepts, uDepts);
        for (DeptVo dept : depts) {
            if (!ArrayUtils.contains(allDepts, dept.getDeptId())) {
                continue;
            }
            Tree<DeptVo> tree = new Tree<DeptVo>();
            tree.setId(dept.getDeptId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserVo> users = userDao.list(new HashMap<String, Object>(16));
        for (UserVo user : users) {
            Tree<DeptVo> tree = new Tree<DeptVo>();
            tree.setId(user.getUserId().toString());
            tree.setParentId(user.getDeptId().toString());
            tree.setText(user.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptVo> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public int updatePersonal(UserVo userVo) {
        return userDao.update(userVo);
    }

    @Override
    public int updatePersonalImg(String src,String userId) throws Exception {
        UserVo userVo = new UserVo();
        userVo.setUserId(userId);
        userVo.setHeadIcon(src);
        return userDao.update(userVo);
    }

    @Override
    public int updateFaceImg(UserVo userVo) {
        return userDao.updateFaceImg(userVo);
    }

    public Tree<LibraryVo> getLibraryTree() {
        List<Tree<LibraryVo>> trees = new ArrayList<Tree<LibraryVo>>();
        List<LibraryVo> librarys = libraryDao.list(new HashMap<String, Object>(16));
        String[] pLibrarys = libraryDao.listParentLibrary();
        String[] uLibrarys = userDao.listAllLibrary();
        String[] allLibrarys = (String[]) ArrayUtils.addAll(pLibrarys, uLibrarys);
        for (LibraryVo library : librarys) {
            if (!ArrayUtils.contains(allLibrarys, library.getLibraryId())) {
                continue;
            }
            Tree<LibraryVo> tree = new Tree<LibraryVo>();
            tree.setId(library.getLibraryId().toString());
            tree.setParentId(library.getParentId().toString());
            tree.setText(library.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "library");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserVo> users = userDao.list(new HashMap<String, Object>(16));
        for (UserVo user : users) {
            Tree<LibraryVo> tree = new Tree<LibraryVo>();
            tree.setId(user.getUserId().toString());
            tree.setParentId(user.getLibraryId().toString());
            tree.setText(user.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<LibraryVo> t = BuildTree.build(trees);
        return t;
    }


}
