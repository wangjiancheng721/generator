package com.wms.basic.service;

import com.wms.basic.entity.Tank;
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
public interface ITankService extends IService<Tank> {

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

    /**
     * 修改
     * @param tank
     */
    void updateTank(Tank tank);

    /**
     * 新增
     * @param tank
     */
    void insertTank(Tank tank);

    /**
     * 删除
     * @param tank
     */
    void deleteTank(Tank tank);

    /**
    * 批量删除
    * @param tanks 要删除的集合列表
    */
    void deleteTankList(List<Tank> tanks);
}
