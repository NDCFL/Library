package top.cflwork.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.cflwork.vo.ReadingRoomVo;
import top.cflwork.service.ReadingRoomService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 阅览室管理
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-18 16:16:56
 */
 
@Controller
@RequestMapping("/readingRoom")
public class ReadingRoomController {
	@Autowired
	private ReadingRoomService readingRoomService;
	
	@GetMapping("readingRoomPage")
	@RequiresPermissions("readingRoom:readingRoomPage")
	public String ReadingRoom(){
	    return "/readingRoom/readingRoom";
	}

	@ResponseBody
	@PostMapping("/list")
	@RequiresPermissions("readingRoom:list")
	public PageUtils list(ReadingRoomVo readingRoomVo){
		//查询列表数据
		List<ReadingRoomVo> readingRoomList = readingRoomService.list(readingRoomVo);
		Long total = readingRoomService.count(readingRoomVo);
		PageUtils pageUtils = new PageUtils(readingRoomList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("readingRoom:add")
	public String add(){
	    return "/readingRoom/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("readingRoom:edit")
	public String edit(@PathVariable("id") String id,Model model){
		ReadingRoomVo readingRoom = readingRoomService.get(id);
		model.addAttribute("readingRoom", readingRoom);
	    return "/readingRoom/edit";
	}

//    @GetMapping("/edit/{id}")
//    @RequiresPermissions("readingRoom:edit")
//    @ResponseBody
//    public ReadingRoomVo edit(@PathVariable("id") String id){
//			ReadingRoomVo readingRoom = readingRoomService.get(id);
//        return readingRoom;
//    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("readingRoom:add")
	public R save( ReadingRoomVo readingRoom){
		if(readingRoomService.save(readingRoom)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("readingRoom:update")
	public R update( ReadingRoomVo readingRoom){
		readingRoomService.update(readingRoom);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("readingRoom:remove")
	public R remove( String id){
		if(readingRoomService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("readingRoom:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		readingRoomService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    @RequiresPermissions("readingRoom:batchSave")
    public R batchSave(List<ReadingRoomVo> readingRoomList){
			readingRoomService.batchSave(readingRoomList);
        return R.ok("批量新增成功");
    }
}
