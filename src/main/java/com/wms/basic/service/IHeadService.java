package com.wms.basic.service;

import com.wms.basic.entity.Head;
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
public interface IHeadService extends IService<Head> {

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

    /**
     * 修改
     * @param head
     */
    void updateHead(Head head);

    /**
     * 新增
     * @param head
     */
    void insertHead(Head head);

    /**
     * 删除
     * @param head
     */
    void deleteHead(Head head);

    /**
    * 批量删除
    * @param heads 要删除的集合列表
    */
    void deleteHeadList(List<Head> heads);
}
