package com.wms.basic.service;

import com.wms.basic.entity.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-20
 */
public interface IItemService extends IService<Item> {

    /**
     * 分页查询
     * @return  Page<Item>
     */
    List<Item> getItemList(Item item);

    /**
     * 根据Item的id获取当前对象
     * @param item
     * @return Item
     */
    Item getItemById(Item item);

    /**
     * 修改
     * @param item
     */
    void updateItem(Item item);

    /**
     * 新增
     * @param item
     */
    void insertItem(Item item);

    /**
     * 删除
     * @param item
     */
    void deleteItem(Item item);

    /**
    * 批量删除
    * @param items 要删除的集合列表
    */
    void deleteItemList(List<Item> items);
}
