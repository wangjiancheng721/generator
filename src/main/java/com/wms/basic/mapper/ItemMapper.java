package com.wms.basic.mapper;

import com.wms.basic.entity.Item;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

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
}
