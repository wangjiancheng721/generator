package com.wms.basic.service;

import com.wms.basic.entity.Prts;
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
public interface IPrtsService extends IService<Prts> {

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

    /**
     * 修改
     * @param prts
     */
    void updatePrts(Prts prts);

    /**
     * 新增
     * @param prts
     */
    void insertPrts(Prts prts);

    /**
     * 删除
     * @param prts
     */
    void deletePrts(Prts prts);

    /**
    * 批量删除
    * @param prtss 要删除的集合列表
    */
    void deletePrtsList(List<Prts> prtss);
}
