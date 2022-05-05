package com.wms.basic.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.Baik;
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
 * @since 2022-03-22
 */
@Mapper
public interface PrtsMapper extends WmsBaseMapper<Prts> {

}
