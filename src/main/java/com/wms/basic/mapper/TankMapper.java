package com.wms.basic.mapper;

import com.wms.basic.entity.Tank;
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
public interface TankMapper extends BaseMapper<Tank> {

    /**
     * 分页查询
     * @return  Page<Tank>
     */
    List<Tank> getTankList(Tank tank);

    /**
     * 根据Tank的id获取当前对象
     * @param tank
     * @return Tank
     */
    Tank getTankById(Tank tank);
}
