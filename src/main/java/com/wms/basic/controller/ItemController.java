package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.Head;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wjc.generator.entity.ResponseEntity;
import com.wms.basic.entity.Item;
import com.wms.basic.service.impl.ItemServiceImpl;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
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
    public ResponseEntity<Item> getItemList(@RequestBody Item item) {
        Page<Item> page = new Page<Item>(item.getPageNo(),item.getPageSize());
        return itemService.getItemList(item,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getItemById")
    public ResponseEntity<Item> getItemById(@RequestBody Item item) {
        return itemService.getItemById(item);
    }

    /**
     * 新增
     */
    @PostMapping("/insertItem")
    public ResponseEntity<Item> insertItem(@RequestBody Item item) {
        return itemService.insertItem(item);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Item> insertBatch(@RequestBody List<Item> items) {
        return itemService.insertBatch(items);
    }

    /**
     * 更新
     */
    @PostMapping("/updateItem")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delItem")
    public ResponseEntity<Item> delItem(@RequestBody Item item) {
        return itemService.deleteItem(item);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delItemList")
    public ResponseEntity<Item> delItemList(@RequestBody List<Item> items) {
        return itemService.deleteItemList(items);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Item> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return itemService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Item item){
        return itemService.exportExcel(item);
    }

}
