package com.wms.basic.service;

import com.wms.basic.entity.Sect;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-20
 */
public interface ISectService extends IService<Sect> {

    /**
     * 分页查询
     * @return  Page<Sect>
     */
    List<Sect> getSectList(Sect sect);

    /**
     * 根据Sect的id获取当前对象
     * @param sect
     * @return Sect
     */
    Sect getSectById(Sect sect);

    /**
     * 修改
     * @param sect
     */
    void updateSect(Sect sect);

    /**
     * 新增
     * @param sect
     */
    void insertSect(Sect sect);

    /**
     * 删除
     * @param sect
     */
    void deleteSect(Sect sect);

    /**
    * 批量删除
    * @param sects 要删除的集合列表
    */
    void deleteSectList(List<Sect> sects);
}
