package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Item;
import com.wms.basic.service.impl.ItemServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getItemList")
    public Object getItemList(@RequestBody Item item) {
        return itemService.getItemList(item);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getItemById")
    public Item getItemById(@RequestBody Item item) {
        return itemService.getItemById(item);
    }

    /**
     * 新增
     */
    @PostMapping("/insertItem")
    public void insertItem(@RequestBody Item item) {
        itemService.insertItem(item);
    }

    /**
     * 更新
     */
    @PostMapping("/updateItem")
    public void updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delItem")
    public void delItem(@RequestBody Item item) {
        itemService.deleteItem(item);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delItemList")
    public void delItemList(@RequestBody List<Item> items) {
        itemService.deleteItemList(items);
    }

}
