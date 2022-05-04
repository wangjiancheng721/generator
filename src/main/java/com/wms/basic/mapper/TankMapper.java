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
 * @since 2022-03-22
 */
@Mapper
public interface TankMapper extends BaseMapper<Tank> {

}
