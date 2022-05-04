package com.wms.basic.service;

import com.wms.basic.entity.Prts;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.wms.basic.entity.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
public interface IPrtsService extends IService<Prts> {

    /**
     * 分页查询
     * @return  Page<Prts>
     */
    public ResponseEntity<Prts> getPrtsList(Prts prts, Page page);

    /**
     * 根据Prts的id获取当前对象
     * @param prts
     * @return Prts
     */
    public ResponseEntity<Prts> getPrtsById(Prts prts);

    /**
     * 修改
     * @param prts
     */
    public ResponseEntity<Prts> updatePrts(Prts prts);

    /**
     * 新增
     * @param prts
     */
    public ResponseEntity<Prts> insertPrts(Prts prts);

    /**
     * 批量新增
     * @param prtss
     */
    public ResponseEntity<Prts> insertBatch(List<Prts> prtss);

    /**
     * 删除
     * @param prts
     */
    public ResponseEntity<Prts> deletePrts(Prts prts);

    /**
    * 批量删除
    * @param prtss 要删除的集合列表
    */
    public ResponseEntity<Prts> deletePrtsList(List<Prts> prtss);

    public ResponseEntity<Prts> importExcel(MultipartFile uploadFile);

    public String exportExcel(Prts prts);
}
