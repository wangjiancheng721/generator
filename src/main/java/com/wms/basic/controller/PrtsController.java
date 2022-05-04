package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.wms.basic.entity.Prts;
import com.wms.basic.service.impl.PrtsServiceImpl;
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
@RequestMapping("/prts")
public class PrtsController {

    @Autowired
    private PrtsServiceImpl prtsService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getPrtsList")
    public ResponseEntity<Prts> getPrtsList(@RequestBody Prts prts) {
        Page<Prts> page = new Page<Prts>(prts.getPageNo(),prts.getPageSize());
        return prtsService.getPrtsList(prts,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getPrtsById")
    public ResponseEntity<Prts> getPrtsById(@RequestBody Prts prts) {
        return prtsService.getPrtsById(prts);
    }

    /**
     * 新增
     */
    @PostMapping("/insertPrts")
    public ResponseEntity<Prts> insertPrts(@RequestBody Prts prts) {
        return prtsService.insertPrts(prts);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Prts> insertBatch(@RequestBody List<Prts> prtss) {
        return prtsService.insertBatch(prtss);
    }

    /**
     * 更新
     */
    @PostMapping("/updatePrts")
    public ResponseEntity<Prts> updatePrts(@RequestBody Prts prts) {
        return prtsService.updatePrts(prts);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delPrts")
    public ResponseEntity<Prts> delPrts(@RequestBody Prts prts) {
        return prtsService.deletePrts(prts);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delPrtsList")
    public ResponseEntity<Prts> delPrtsList(@RequestBody List<Prts> prtss) {
        return prtsService.deletePrtsList(prtss);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Prts> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return prtsService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Prts prts){
        return prtsService.exportExcel(prts);
    }

}
