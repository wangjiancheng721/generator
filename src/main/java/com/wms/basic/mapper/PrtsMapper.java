package com.wms.basic.mapper;

import com.wms.basic.entity.Prts;
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
public interface PrtsMapper extends BaseMapper<Prts> {

    /**
     * 分页查询
     * @return  Page<Prts>
     */
    List<Prts> getPrtsList(Prts prts);

    /**
     * 根据Prts的id获取当前对象
     * @param prts
     * @return Prts
     */
    Prts getPrtsById(Prts prts);
}
