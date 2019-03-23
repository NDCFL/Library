package top.cflwork.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

import top.cflwork.common.ResponseJson;
import top.cflwork.common.XmlSendUtil;
import top.cflwork.config.Constant;
import top.cflwork.util.*;
import top.cflwork.vo.CollectionBookVo;
import top.cflwork.service.CollectionBookService;
import top.cflwork.vo.ReadUserVo;
import top.cflwork.vo.SendVo;
import top.cflwork.vo.xmlvo.BookSearchRootVo;
import top.cflwork.vo.xmlvo.BookSearchVo;
import top.cflwork.vo.xmlvo.ReadRootVo;

/**
 * 馆藏表
 *
 * @author cfl
 * @email 275300091@qq.com
 * @date 2019-03-11 13:23:06
 */

@Controller
@RequestMapping("/collectionBook")
@Api(value = "/collectionBook", description = "图书馆藏模块")
public class CollectionBookController extends BaseController {
    @Autowired
    private CollectionBookService collectionBookService;

    @GetMapping("collectionBookPage")
    @RequiresPermissions("collectionBook:collectionBookPage")
    public String CollectionBook() {
        return "/collectionBook/collectionBook";
    }

    @ResponseBody
    @PostMapping("/list")
    @RequiresPermissions("collectionBook:list")
    public PageUtils list(CollectionBookVo collectionBookVo) {
        //查询列表数据
        collectionBookVo.setLibraryId(getLibraryId());
        List<CollectionBookVo> collectionBookList = collectionBookService.list(collectionBookVo);
        Long total = collectionBookService.count(collectionBookVo);
        PageUtils pageUtils = new PageUtils(collectionBookList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("collectionBook:add")
    public String add() {
        return "/collectionBook/add";
    }


    @GetMapping("/edit/{id}")
    @RequiresPermissions("collectionBook:edit")
    @ResponseBody
    public CollectionBookVo edit(@PathVariable("id") String id) {
        CollectionBookVo collectionBook = collectionBookService.get(id);
        return collectionBook;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("collectionBook:add")
    public R save(CollectionBookVo collectionBook) {
        collectionBook.setLibraryId(getLibraryId());
        if (collectionBookService.save(collectionBook) > 0) {
            return R.ok("新增成功");
        }
        return R.error("新增失败");
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("collectionBook:update")
    public R update(CollectionBookVo collectionBook) {
        collectionBookService.update(collectionBook);
        return R.ok("修改成功");
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("collectionBook:remove")
    public R remove(String id) {
        if (collectionBookService.remove(id) > 0) {
            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("collectionBook:batchRemove")
    public R remove(@RequestParam("ids[]") String[] ids) {
        collectionBookService.batchRemove(ids);
        return R.ok("批量删除成功");
    }

    /**
     * 删除
     */
    @PostMapping("/batchSave")
    @ResponseBody
    @RequiresPermissions("collectionBook:batchSave")
    public R batchSave(List<CollectionBookVo> collectionBookList) {
        collectionBookList.stream().forEach(e -> {
            e.setLibraryId(getLibraryId());
        });
        collectionBookService.batchSave(collectionBookList);
        return R.ok("批量新增成功");
    }

}
