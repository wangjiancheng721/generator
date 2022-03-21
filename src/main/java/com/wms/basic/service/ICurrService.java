package com.wms.basic.service;

import com.wms.basic.entity.Curr;
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
public interface ICurrService extends IService<Curr> {

    /**
     * 分页查询
     * @return  Page<Curr>
     */
    List<Curr> getCurrList(Curr curr);

    /**
     * 根据Curr的id获取当前对象
     * @param curr
     * @return Curr
     */
    Curr getCurrById(Curr curr);

    /**
     * 修改
     * @param curr
     */
    void updateCurr(Curr curr);

    /**
     * 新增
     * @param curr
     */
    void insertCurr(Curr curr);

    /**
     * 删除
     * @param curr
     */
    void deleteCurr(Curr curr);

    /**
    * 批量删除
    * @param currs 要删除的集合列表
    */
    void deleteCurrList(List<Curr> currs);
}
