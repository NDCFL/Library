package top.cflwork.service;

import top.cflwork.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
	UserVo get(String id);

	List<UserVo> list(Map<String, Object> map);

	long count(Map<String, Object> map);

	int save(UserVo user);

	int update(UserVo user);

	int remove(String userId);

	int batchremove(String[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(String userId);

	int resetPwd(UserPwdVo userPwdVo, UserVo userVo) throws Exception;
	int adminResetPwd(UserPwdVo userPwdVo) throws Exception;
	Tree<DeptVo> getTree();

	/**
	 * 更新个人信息
	 * @param userVo
	 * @return
	 */
	int updatePersonal(UserVo userVo);

	/**
	 * 更新个人图片
	 * @param userId 用户ID
	 * @throws Exception
	 */
    int updatePersonalImg(String base64,String userId) throws Exception;

	int updateFaceImg(UserVo userVo);

	Tree<LibraryVo> getLibraryTree();


}
