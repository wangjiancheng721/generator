package com.wms.basic.service;

import com.wms.basic.entity.ResponseEntity;
import com.wms.basic.entity.Tank;
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
public interface ITankService extends IService<Tank> {

    /**
     * 分页查询
     * @return  Page<Tank>
     */
    public ResponseEntity<Tank> getTankList(Tank tank, Page page);

    /**
     * 根据Tank的id获取当前对象
     * @param tank
     * @return Tank
     */
    public ResponseEntity<Tank> getTankById(Tank tank);

    /**
     * 修改
     * @param tank
     */
    public ResponseEntity<Tank> updateTank(Tank tank);

    /**
     * 新增
     * @param tank
     */
    public ResponseEntity<Tank> insertTank(Tank tank);

    /**
     * 批量新增
     * @param tanks
     */
    public ResponseEntity<Tank> insertBatch(List<Tank> tanks);

    /**
     * 删除
     * @param tank
     */
    public ResponseEntity<Tank> deleteTank(Tank tank);

    /**
    * 批量删除
    * @param tanks 要删除的集合列表
    */
    public ResponseEntity<Tank> deleteTankList(List<Tank> tanks);

    public ResponseEntity<Tank> importExcel(MultipartFile uploadFile);

    public String exportExcel(Tank tank);
}
