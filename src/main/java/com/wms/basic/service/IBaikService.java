package com.wms.basic.service;

import com.wms.basic.entity.Baik;
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
public interface IBaikService extends IService<Baik> {

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

    /**
     * 修改
     * @param baik
     */
    void updateBaik(Baik baik);

    /**
     * 新增
     * @param baik
     */
    void insertBaik(Baik baik);

    /**
     * 删除
     * @param baik
     */
    void deleteBaik(Baik baik);

    /**
    * 批量删除
    * @param baiks 要删除的集合列表
    */
    void deleteBaikList(List<Baik> baiks);
}
