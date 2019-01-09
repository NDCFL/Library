package top.cflwork.controller;


import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.service.LogService;
import top.cflwork.vo.LogVo;
import top.cflwork.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/log")
@Controller
public class LogController {
	@Autowired
	public LogService logService;
	public String prefix = "/log";
	@GetMapping("/logPage")
	public String log() {
		return prefix + "/log";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageVo<LogVo> list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		PageVo<LogVo> page = logService.queryList(query);
		return page;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	public R remove(Long id) {
		if (logService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	public R batchRemove(@RequestParam("ids[]") Long[] ids) {
		int r = logService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
