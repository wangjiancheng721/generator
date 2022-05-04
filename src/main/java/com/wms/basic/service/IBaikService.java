package com.wms.basic.service;

import com.wms.basic.entity.Baik;
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
public interface IBaikService extends IService<Baik> {

    /**
     * 分页查询
     * @return  Page<Baik>
     */
    public ResponseEntity<Baik> getBaikList(Baik baik, Page page);

    /**
     * 根据Baik的id获取当前对象
     * @param baik
     * @return Baik
     */
    public ResponseEntity<Baik> getBaikById(Baik baik);

    /**
     * 修改
     * @param baik
     */
    public ResponseEntity<Baik> updateBaik(Baik baik);

    /**
     * 新增
     * @param baik
     */
    public ResponseEntity<Baik> insertBaik(Baik baik);

    /**
     * 批量新增
     * @param baiks
     */
    public ResponseEntity<Baik> insertBatch(List<Baik> baiks);

    /**
     * 删除
     * @param baik
     */
    public ResponseEntity<Baik> deleteBaik(Baik baik);

    /**
    * 批量删除
    * @param baiks 要删除的集合列表
    */
    public ResponseEntity<Baik> deleteBaikList(List<Baik> baiks);

    public ResponseEntity<Baik> importExcel(MultipartFile uploadFile);

    public String exportExcel(Baik baik);
}
