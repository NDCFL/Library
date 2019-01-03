package top.cflwork.service;

import top.cflwork.domain.DeptVo;
import top.cflwork.domain.UserVo;
import top.cflwork.vo.Tree;
import top.cflwork.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
	UserVo get(Long id);

	List<UserVo> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserVo user);

	int update(UserVo user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserVO userVO,UserVo userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptVo> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(UserVo userDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
