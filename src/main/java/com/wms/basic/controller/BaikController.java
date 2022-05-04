package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.wms.basic.entity.Baik;
import com.wms.basic.service.impl.BaikServiceImpl;
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
@RequestMapping("/baik")
public class BaikController {

    @Autowired
    private BaikServiceImpl baikService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getBaikList")
    public ResponseEntity<Baik> getBaikList(@RequestBody Baik baik) {
        Page<Baik> page = new Page<Baik>(baik.getPageNo(),baik.getPageSize());
        return baikService.getBaikList(baik,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getBaikById")
    public ResponseEntity<Baik> getBaikById(@RequestBody Baik baik) {
        ResponseEntity<Baik> result = baikService.getBaikById(baik);
        return result;
    }

    /**
     * 新增
     */
    @PostMapping("/insertBaik")
    public ResponseEntity<Baik> insertBaik(@RequestBody Baik baik) {
        return baikService.insertBaik(baik);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Baik> insertBatch(@RequestBody List<Baik> baiks) {
        return baikService.insertBatch(baiks);
    }

    /**
     * 更新
     */
    @PostMapping("/updateBaik")
    public ResponseEntity<Baik> updateBaik(@RequestBody Baik baik) {
        return baikService.updateBaik(baik);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delBaik")
    public ResponseEntity<Baik> delBaik(@RequestBody Baik baik) {
        return baikService.deleteBaik(baik);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delBaikList")
    public ResponseEntity<Baik> delBaikList(@RequestBody List<Baik> baiks) {
        return baikService.deleteBaikList(baiks);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Baik> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return baikService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Baik baik){
        return baikService.exportExcel(baik);
    }

}
