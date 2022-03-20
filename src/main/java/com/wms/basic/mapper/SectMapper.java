package com.wms.basic.mapper;

import com.wms.basic.entity.Sect;
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
public interface SectMapper extends BaseMapper<Sect> {

    /**
     * 分页查询
     * @return  Page<Sect>
     */
    List<Sect> getSectList(Sect sect);

    /**
     * 根据Sect的id获取当前对象
     * @param sect
     * @return Sect
     */
    Sect getSectById(Sect sect);
}
