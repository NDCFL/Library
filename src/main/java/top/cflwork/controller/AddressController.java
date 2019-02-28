package top.cflwork.controller;

import java.util.List;
import java.util.Map;

import com.xiaoleilu.hutool.date.DateUtil;
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
import top.cflwork.vo.AddressVo;
import top.cflwork.service.AddressService;
import top.cflwork.util.PageUtils;
import top.cflwork.util.Query;
import top.cflwork.util.R;

/**
 * 存储读者的地址
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-01-17 14:55:55
 */

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("addressPage")
    public String Address() {
        return "/address/address";
    }

    @ResponseBody
    @PostMapping("/list")
    public List<AddressVo> list(AddressVo addressVo) {
        //查询列表数据
        List<AddressVo> addressList = addressService.list(addressVo);
        return addressList;
    }
    @ResponseBody
    @PostMapping("/findList/{id}")
    public List<AddressVo> findList(@PathVariable("id") String id) {
        //查询列表数据
        AddressVo addressVo = new AddressVo();
        addressVo.setReadUserId(id);
        Pager pager = new Pager();
        pager.setOrder("desc");
        pager.setSort("create_time");
        pager.setPaging(false);
        addressVo.setPager(pager);
        List<AddressVo> addressList = addressService.list(addressVo);
        return addressList;
    }

    @GetMapping("/add")
    public String add() {
        return "/address/add";
    }

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("address:edit")
	public String edit(@PathVariable("id") String id,Model model){
		AddressVo address = addressService.get(id);
		model.addAttribute("address", address);
	    return "/address/edit";
	}*/

    @GetMapping("/edit/{id}")
    @ResponseBody
    public AddressVo edit(@PathVariable("id") String id) {
        AddressVo address = addressService.get(id);
        return address;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(AddressVo address) {
        if (addressService.save(address) > 0) {
            return R.ok("新增成功");
        }
        return R.error("新增失败");
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(AddressVo address) {
        address.setUpdateTime(DateUtil.date());
        addressService.update(address);
        return R.ok("修改成功");
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public R remove(String id) {
        if (addressService.remove(id) > 0) {
            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") String[] ids) {
        addressService.batchRemove(ids);
        return R.ok("批量删除成功");
    }

    /**
     * 批量保存
     */
    @PostMapping("/batchSave")
    @ResponseBody
    public R batchSave(List<AddressVo> addressList) {
        addressService.batchSave(addressList);
        return R.ok("批量新增成功");
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public R saveOrUpdate(AddressVo addressVo) {
        if(null==addressVo.getId() || "".equals(addressVo.getId())){
            addressService.save(addressVo);
        }else{
            addressService.update(addressVo);
        }
        return R.ok("操作成功");
    }


}
