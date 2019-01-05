package top.cflwork.controller;

import top.cflwork.config.CflworksConfig;
import top.cflwork.service.FileService;
import top.cflwork.util.*;
import top.cflwork.vo.FileListVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-09-19 16:02:20
 */
@Controller
@RequestMapping("/sysFile")
public class FileController extends BaseController {

	@Autowired
	private FileService sysFileService;

	@Autowired
	private CflworksConfig cflworksConfig;

	@GetMapping("sysFilePage")
	@RequiresPermissions("sysFile:list")
    public String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "/file/file";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sysFile:list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<FileListVo> sysFileList = sysFileService.list(query);
		int total = sysFileService.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("bComments")
    public String add() {
		return "/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("bComments")
    public String edit(Long id, Model model) {
		FileListVo sysFile = sysFileService.get(id);
		model.addAttribute("sysFile", sysFile);
		return "/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("info")
	public R info(@PathVariable("id") Long id) {
		FileListVo sysFile = sysFileService.get(id);
		return R.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("save")
	public R save(FileListVo sysFile) {
		if (sysFileService.save(sysFile) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("update")
	public R update(@RequestBody FileListVo sysFile) {
		sysFileService.update(sysFile);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("remove")
	public R remove(Long id, HttpServletRequest request) {
		String fileName = cflworksConfig.getUploadPath() + sysFileService.get(id).getUrl().replace("/files/", "");
		if (sysFileService.remove(id) > 0) {
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return R.error("数据库记录删除成功，文件删除失败");
			}
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("remove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		sysFileService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileListVo sysFile = new FileListVo(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			FileUtil.uploadFile(file.getBytes(), cflworksConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (sysFileService.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl());
		}
		return R.error();
	}


}
