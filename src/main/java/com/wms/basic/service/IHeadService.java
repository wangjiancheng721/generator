package com.wms.basic.service;

import com.wms.basic.entity.Cust;
import com.wms.basic.entity.Head;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.wjc.generator.entity.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
public interface IHeadService extends IService<Head> {

    /**
     * 分页查询
     * @return  Page<Head>
     */
    public ResponseEntity<Head> getHeadList(Head head, Page page);

    /**
     * 根据Head的id获取当前对象
     * @param head
     * @return Head
     */
    public ResponseEntity<Head> getHeadById(Head head);

    /**
     * 修改
     * @param head
     */
    public ResponseEntity<Head> updateHead(Head head);

    /**
     * 新增
     * @param head
     */
    public ResponseEntity<Head> insertHead(Head head);

    /**
     * 批量新增
     * @param heads
     */
    public ResponseEntity<Head> insertBatch(List<Head> heads);

    /**
     * 删除
     * @param head
     */
    public ResponseEntity<Head> deleteHead(Head head);

    /**
    * 批量删除
    * @param heads 要删除的集合列表
    */
    public ResponseEntity<Head> deleteHeadList(List<Head> heads);

    public ResponseEntity<Head> importExcel(MultipartFile uploadFile);

    public String exportExcel(Head head);
}
