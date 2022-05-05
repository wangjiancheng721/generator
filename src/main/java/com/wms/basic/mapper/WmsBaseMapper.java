package com.wms.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.Baik;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
@Mapper
public interface WmsBaseMapper<T> extends BaseMapper<T> {

    int insert(T t);

    int insertBatch(List<T> ts);

    int update(T t);

    int deleteById(T t);

    int deleteBatchIds(List<T> ts);

    T selectOne(T t);

    List<T> selectList(T t);

    Page selectPage(T t, Page page);

}
