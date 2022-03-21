package com.wms.basic.mapper;

import com.wms.basic.entity.Cust;
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
public interface CustMapper extends BaseMapper<Cust> {

    /**
     * 分页查询
     * @return  Page<Cust>
     */
    List<Cust> getCustList(Cust cust);

    /**
     * 根据Cust的id获取当前对象
     * @param cust
     * @return Cust
     */
    Cust getCustById(Cust cust);
}
