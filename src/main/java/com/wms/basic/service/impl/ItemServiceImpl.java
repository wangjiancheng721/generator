package com.wms.basic.service.impl;

import com.wms.basic.entity.Item;
import com.wms.basic.mapper.ItemMapper;
import com.wms.basic.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getItemList(Item item){
        List<Item> items = null;
        items  = itemMapper.getItemList(item);
        return items;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Item getItemById(Item item){
        item = itemMapper.getItemById(item);
        return item;
    }

    @Override
    public void updateItem(Item item){
        itemMapper.updateById(item);
    }

    @Override
    public void insertItem(Item item){
        itemMapper.insert(item);
    }

    @Override
    public void deleteItem(Item item){
        itemMapper.deleteById(item);
    }

    @Override
    public void deleteItemList(List<Item> items) {
        itemMapper.deleteBatchIds(items);
    }
}
