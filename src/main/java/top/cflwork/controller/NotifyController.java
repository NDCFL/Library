package top.cflwork.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.cflwork.config.Constant;
import top.cflwork.vo.NotifyVo;
import top.cflwork.vo.NotifyRecordDO;
import top.cflwork.service.DictService;
import top.cflwork.service.NotifyRecordService;
import top.cflwork.service.NotifyService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;
import top.cflwork.vo.DictVo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知通告
 *
 * @author 陈飞龙
 * @email 275300091@qq.com
 * @date 2017-10-05 17:11:16
 */

@Controller
@RequestMapping("/oa/notify")
public class NotifyController extends BaseController {
	@Autowired
	private NotifyService notifyService;
	@Autowired
	private NotifyRecordService notifyRecordService;
	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("oa:notify:notify")
	public String oaNotify() {
		return "oa/notify/notify";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("oa:notify:notify")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<NotifyVo> notifyList = notifyService.list(query);
		int total = notifyService.count(query);
		PageUtils pageUtils = new PageUtils(notifyList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("oa:notify:add")
	public String add() {
		return "oa/notify/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("oa:notify:edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		NotifyVo notify = notifyService.get(id);
		List<DictVo> dictDOS = dictService.listByType("oa_notify_type");
		String type = notify.getType();
		for (DictVo dictDO:dictDOS){
			if(type.equals(dictDO.getValue())){
				dictDO.setRemarks("checked");
			}
		}
		model.addAttribute("oaNotifyTypes",dictDOS);
		model.addAttribute("notify", notify);
		return "oa/notify/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("oa:notify:add")
	public R save(NotifyVo notify) {
		notify.setCreateBy(getUserId());
		if (notifyService.save(notify) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("oa:notify:edit")
	public R update(NotifyVo notify) {
		notifyService.update(notify);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("oa:notify:remove")
	public R remove(Long id) {
		if (notifyService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("oa:notify:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		notifyService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/message")
	public PageUtils message() {
		Map<String, Object> params = new HashMap<>(16);
		params.put("pageIndex", 0);
		params.put("pageSize", 3);
		Query query = new Query(params);
        query.put("userId", getUserId());
        query.put("isRead", Constant.OA_NOTIFY_READ_NO);
		return notifyService.selfList(query);
	}

	@GetMapping("/selfNotify")
	public String selefNotify() {
		return "oa/notify/selfNotify";
	}

	@ResponseBody
	@GetMapping("/selfList")
	public PageUtils selfList(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		query.put("userId", getUserId());

		return notifyService.selfList(query);
	}

	@GetMapping("/read/{id}")
	@RequiresPermissions("oa:notify:edit")
	public String read(@PathVariable("id") Long id, Model model) {
		NotifyVo notify = notifyService.get(id);
		//更改阅读状态
		NotifyRecordDO notifyRecordDO = new NotifyRecordDO();
		notifyRecordDO.setNotifyId(id);
		notifyRecordDO.setUserId(getUserId());
		notifyRecordDO.setReadDate(new Date());
		notifyRecordDO.setIsRead(Constant.OA_NOTIFY_READ_YES);
		notifyRecordService.changeRead(notifyRecordDO);
		model.addAttribute("notify", notify);
		return "oa/notify/read";
	}



}
