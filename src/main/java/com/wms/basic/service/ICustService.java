package com.wms.basic.service;

import com.wms.basic.entity.Curr;
import com.wms.basic.entity.Cust;
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
public interface ICustService extends IService<Cust> {

    /**
     * 分页查询
     * @return  Page<Cust>
     */
    public ResponseEntity<Cust> getCustList(Cust cust, Page page);

    /**
     * 根据Cust的id获取当前对象
     * @param cust
     * @return Cust
     */
    public ResponseEntity<Cust> getCustById(Cust cust);

    /**
     * 修改
     * @param cust
     */
    public ResponseEntity<Cust> updateCust(Cust cust);

    /**
     * 新增
     * @param cust
     */
    public ResponseEntity<Cust> insertCust(Cust cust);

    /**
     * 批量新增
     * @param custs
     */
    public ResponseEntity<Cust> insertBatch(List<Cust> custs);

    /**
     * 删除
     * @param cust
     */
    public ResponseEntity<Cust> deleteCust(Cust cust);

    /**
    * 批量删除
    * @param custs 要删除的集合列表
    */
    public ResponseEntity<Cust> deleteCustList(List<Cust> custs);

    public ResponseEntity<Cust> importExcel(MultipartFile uploadFile);

    public String exportExcel(Cust cust);
}
