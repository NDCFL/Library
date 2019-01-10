package top.cflwork.controller;


import com.alibaba.druid.sql.PagerUtils;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.service.LogService;
import top.cflwork.vo.LogVo;
import top.cflwork.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
	public PageUtils<LogVo> list(LogVo logVo) {
        List<LogVo> logVoList = logService.list(logVo);
        long total = logService.count(logVo);
        PageUtils<LogVo> pagerUtils = new PageUtils<LogVo>(logVoList,total);
		return pagerUtils;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	public R remove(String id) {
		if (logService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	public R batchRemove(@RequestParam("ids[]") String[] ids) {
		int r = logService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
