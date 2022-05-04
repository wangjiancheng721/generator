package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.Curr;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wjc.generator.entity.ResponseEntity;
import com.wms.basic.entity.Cust;
import com.wms.basic.service.impl.CustServiceImpl;
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
@RequestMapping("/cust")
public class CustController {

    @Autowired
    private CustServiceImpl custService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getCustList")
    public ResponseEntity<Cust> getCustList(@RequestBody Cust cust) {
        Page<Cust> page = new Page<Cust>(cust.getPageNo(),cust.getPageSize());
        return custService.getCustList(cust,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getCustById")
    public ResponseEntity<Cust> getCustById(@RequestBody Cust cust) {
        return custService.getCustById(cust);
    }

    /**
     * 新增
     */
    @PostMapping("/insertCust")
    public ResponseEntity<Cust> insertCust(@RequestBody Cust cust) {
        return custService.insertCust(cust);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Cust> insertBatch(@RequestBody List<Cust> custs) {
        return custService.insertBatch(custs);
    }

    /**
     * 更新
     */
    @PostMapping("/updateCust")
    public ResponseEntity<Cust> updateCust(@RequestBody Cust cust) {
        return custService.updateCust(cust);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delCust")
    public ResponseEntity<Cust> delCust(@RequestBody Cust cust) {
        return custService.deleteCust(cust);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delCustList")
    public ResponseEntity<Cust> delCustList(@RequestBody List<Cust> custs) {
        return custService.deleteCustList(custs);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Cust> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return custService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Cust cust){
        return custService.exportExcel(cust);
    }
}
