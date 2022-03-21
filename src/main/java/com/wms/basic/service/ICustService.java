package com.wms.basic.service;

import com.wms.basic.entity.Cust;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
public interface ICustService extends IService<Cust> {

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

    /**
     * 修改
     * @param cust
     */
    void updateCust(Cust cust);

    /**
     * 新增
     * @param cust
     */
    void insertCust(Cust cust);

    /**
     * 删除
     * @param cust
     */
    void deleteCust(Cust cust);

    /**
    * 批量删除
    * @param custs 要删除的集合列表
    */
    void deleteCustList(List<Cust> custs);
}
