package com.wms.basic.service;

import com.wms.basic.entity.Baik;
import com.wms.basic.entity.Curr;
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
public interface ICurrService extends IService<Curr> {

    /**
     * 分页查询
     * @return  Page<Curr>
     */
    public ResponseEntity<Curr> getCurrList(Curr curr, Page page);

    /**
     * 根据Curr的id获取当前对象
     * @param curr
     * @return Curr
     */
    public ResponseEntity<Curr> getCurrById(Curr curr);

    /**
     * 修改
     * @param curr
     */
    public ResponseEntity<Curr> updateCurr(Curr curr);

    /**
     * 新增
     * @param curr
     */
    public ResponseEntity<Curr> insertCurr(Curr curr);

    /**
     * 批量新增
     * @param currs
     */
    public ResponseEntity<Curr> insertBatch(List<Curr> currs);

    /**
     * 删除
     * @param curr
     */
    public ResponseEntity<Curr> deleteCurr(Curr curr);

    /**
    * 批量删除
    * @param currs 要删除的集合列表
    */
    public ResponseEntity<Curr> deleteCurrList(List<Curr> currs);

    public ResponseEntity<Curr> importExcel(MultipartFile uploadFile);

    public String exportExcel(Curr curr);
}
