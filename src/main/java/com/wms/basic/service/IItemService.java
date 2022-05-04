package com.wms.basic.service;

import com.wms.basic.entity.Head;
import com.wms.basic.entity.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.wjc.generator.entity.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
public interface IItemService extends IService<Item> {

    /**
     * 分页查询
     * @return  Page<Item>
     */
    public ResponseEntity<Item> getItemList(Item item, Page page);

    /**
     * 根据Item的id获取当前对象
     * @param item
     * @return Item
     */
    public ResponseEntity<Item> getItemById(Item item);

    /**
     * 修改
     * @param item
     */
    public ResponseEntity<Item> updateItem(Item item);

    /**
     * 新增
     * @param item
     */
    public ResponseEntity<Item> insertItem(Item item);

    /**
     * 批量新增
     * @param items
     */
    public ResponseEntity<Item> insertBatch(List<Item> items);

    /**
     * 删除
     * @param item
     */
    public ResponseEntity<Item> deleteItem(Item item);

    /**
    * 批量删除
    * @param items 要删除的集合列表
    */
    public ResponseEntity<Item> deleteItemList(List<Item> items);

    public ResponseEntity<Item> importExcel(MultipartFile uploadFile);

    public String exportExcel(Item item);
}
