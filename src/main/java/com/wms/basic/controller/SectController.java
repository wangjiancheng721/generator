package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.wms.basic.entity.Sect;
import com.wms.basic.service.impl.SectServiceImpl;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/sect")
public class SectController {

    @Autowired
    private SectServiceImpl sectService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getSectList")
    public ResponseEntity<Sect> getSectList(@RequestBody Sect sect) {
        Page<Sect> page = new Page<Sect>(sect.getPageNo(),sect.getPageSize());
        return sectService.getSectList(sect,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getSectById")
    public ResponseEntity<Sect> getSectById(@RequestBody Sect sect) {
        return sectService.getSectById(sect);
    }

    /**
     * 新增
     */
    @PostMapping("/insertSect")
    public ResponseEntity<Sect> insertSect(@RequestBody Sect sect) {
        return sectService.insertSect(sect);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Sect> insertBatch(@RequestBody List<Sect> sects) {
        return sectService.insertBatch(sects);
    }

    /**
     * 更新
     */
    @PostMapping("/updateSect")
    public ResponseEntity<Sect> updateSect(@RequestBody Sect sect) {
        return sectService.updateSect(sect);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delSect")
    public ResponseEntity<Sect> delSect(@RequestBody Sect sect) {
        return sectService.deleteSect(sect);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delSectList")
    public ResponseEntity<Sect> delSectList(@RequestBody List<Sect> sects) {
        return sectService.deleteSectList(sects);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Sect> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return sectService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Sect sect){
        return sectService.exportExcel(sect);
    }

}
