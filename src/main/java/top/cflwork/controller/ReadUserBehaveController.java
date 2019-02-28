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

import top.cflwork.common.Pager;
import top.cflwork.vo.ReadUserBehaveVo;
import top.cflwork.service.ReadUserBehaveService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 读者的兴趣爱好
 * 
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-02-28 14:08:14
 */
 
@Controller
@RequestMapping("/readUserBehave")
public class ReadUserBehaveController {
	@Autowired
	private ReadUserBehaveService readUserBehaveService;
	
	@GetMapping("readUserBehavePage")
	public String ReadUserBehave(){
	    return "/readUserBehave/readUserBehave";
	}

	@ResponseBody
	@PostMapping("/list")
	public PageUtils list(ReadUserBehaveVo readUserBehaveVo){
		//查询列表数据
		List<ReadUserBehaveVo> readUserBehaveList = readUserBehaveService.list(readUserBehaveVo);
		Long total = readUserBehaveService.count(readUserBehaveVo);
		PageUtils pageUtils = new PageUtils(readUserBehaveList, total);
		return pageUtils;
	}

	@ResponseBody
	@PostMapping("/findList/{id}")
	public List<ReadUserBehaveVo> findList(@PathVariable("id") String id) {
		//查询列表数据
		ReadUserBehaveVo readUserBehaveVo = new ReadUserBehaveVo();
		readUserBehaveVo.setReadUserId(id);
		Pager pager = new Pager();
		pager.setOrder("desc");
		pager.setSort("create_time");
		pager.setPaging(false);
		readUserBehaveVo.setPager(pager);
		List<ReadUserBehaveVo> readUserBehaveVoList = readUserBehaveService.list(readUserBehaveVo);
		return readUserBehaveVoList;
	}

	@PostMapping("/saveOrUpdate")
	@ResponseBody
	public R saveOrUpdate(ReadUserBehaveVo readUserBehaveVo) {
		if(null==readUserBehaveVo.getId() || "".equals(readUserBehaveVo.getId())){
			readUserBehaveService.save(readUserBehaveVo);
		}else{
			readUserBehaveService.update(readUserBehaveVo);
		}
		return R.ok("操作成功");
	}


	@GetMapping("/add")
	public String add(){
	    return "/readUserBehave/add";
	}

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("readUserBehave:edit")
	public String edit(@PathVariable("id") String id,Model model){
		ReadUserBehaveVo readUserBehave = readUserBehaveService.get(id);
		model.addAttribute("readUserBehave", readUserBehave);
	    return "/readUserBehave/edit";
	}*/

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ReadUserBehaveVo edit(@PathVariable("id") String id){
			ReadUserBehaveVo readUserBehave = readUserBehaveService.get(id);
        return readUserBehave;
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( ReadUserBehaveVo readUserBehave){
		if(readUserBehaveService.save(readUserBehave)>0){
			return R.ok("新增成功");
		}
		return R.error("新增失败");
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( ReadUserBehaveVo readUserBehave){
		readUserBehaveService.update(readUserBehave);
		return R.ok("修改成功");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( String id){
		if(readUserBehaveService.remove(id)>0){
		return R.ok("删除成功");
		}
		return R.error("删除失败");
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] ids){
		readUserBehaveService.batchRemove(ids);
		return R.ok("批量删除成功");
	}
    /**
     * 删除
     */
    @PostMapping( "/batchSave")
    @ResponseBody
    public R batchSave(List<ReadUserBehaveVo> readUserBehaveList){
			readUserBehaveService.batchSave(readUserBehaveList);
        return R.ok("批量新增成功");
    }
}
