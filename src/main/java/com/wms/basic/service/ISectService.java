package com.wms.basic.service;

import com.wms.basic.entity.ResponseEntity;
import com.wms.basic.entity.Sect;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
public interface ISectService extends IService<Sect> {

    /**
     * 分页查询
     * @return  Page<Sect>
     */
    public ResponseEntity<Sect> getSectList(Sect sect, Page page);

    /**
     * 根据Sect的id获取当前对象
     * @param sect
     * @return Sect
     */
    public ResponseEntity<Sect> getSectById(Sect sect);

    /**
     * 修改
     * @param sect
     */
    public ResponseEntity<Sect> updateSect(Sect sect);

    /**
     * 新增
     * @param sect
     */
    public ResponseEntity<Sect> insertSect(Sect sect);

    /**
     * 批量新增
     * @param sects
     */
    public ResponseEntity<Sect> insertBatch(List<Sect> sects);

    /**
     * 删除
     * @param sect
     */
    public ResponseEntity<Sect> deleteSect(Sect sect);

    /**
    * 批量删除
    * @param sects 要删除的集合列表
    */
    public ResponseEntity<Sect> deleteSectList(List<Sect> sects);

    public ResponseEntity<Sect> importExcel(MultipartFile uploadFile);

    public String exportExcel(Sect sect);
}
