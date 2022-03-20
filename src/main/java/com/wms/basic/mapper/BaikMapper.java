package com.wms.basic.mapper;

import com.wms.basic.entity.Baik;
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
public interface BaikMapper extends BaseMapper<Baik> {

    /**
     * 分页查询
     * @return  Page<Baik>
     */
    List<Baik> getBaikList(Baik baik);

    /**
     * 根据Baik的id获取当前对象
     * @param baik
     * @return Baik
     */
    Baik getBaikById(Baik baik);
}
