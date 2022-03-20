package com.wms.basic.mapper;

import com.wms.basic.entity.Head;
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
public interface HeadMapper extends BaseMapper<Head> {

    /**
     * 分页查询
     * @return  Page<Head>
     */
    List<Head> getHeadList(Head head);

    /**
     * 根据Head的id获取当前对象
     * @param head
     * @return Head
     */
    Head getHeadById(Head head);
}
