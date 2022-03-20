package com.wms.basic.mapper;

import com.wms.basic.entity.Curr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjc
 * @since 2022-03-20
 */
@Mapper
public interface CurrMapper extends BaseMapper<Curr> {

    /**
     * 分页查询
     * @return  Page<Curr>
     */
    List<Curr> getCurrList(Curr curr);

    /**
     * 根据Curr的id获取当前对象
     * @param curr
     * @return Curr
     */
    Curr getCurrById(Curr curr);
}
