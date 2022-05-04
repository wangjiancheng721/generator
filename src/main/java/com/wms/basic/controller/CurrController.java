package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.Baik;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wjc.generator.entity.ResponseEntity;
import com.wms.basic.entity.Curr;
import com.wms.basic.service.impl.CurrServiceImpl;
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
@RequestMapping("/curr")
public class CurrController {

    @Autowired
    private CurrServiceImpl currService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getCurrList")
    public ResponseEntity<Curr> getCurrList(@RequestBody Curr curr) {
        Page<Curr> page = new Page<Curr>(curr.getPageNo(),curr.getPageSize());
        return currService.getCurrList(curr,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getCurrById")
    public ResponseEntity<Curr> getCurrById(@RequestBody Curr curr) {
        return currService.getCurrById(curr);
    }

    /**
     * 新增
     */
    @PostMapping("/insertCurr")
    public ResponseEntity<Curr> insertCurr(@RequestBody Curr curr) {
        return currService.insertCurr(curr);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Curr> insertBatch(@RequestBody List<Curr> currs) {
        return currService.insertBatch(currs);
    }

    /**
     * 更新
     */
    @PostMapping("/updateCurr")
    public ResponseEntity<Curr> updateCurr(@RequestBody Curr curr) {
        return currService.updateCurr(curr);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delCurr")
    public ResponseEntity<Curr> delCurr(@RequestBody Curr curr) {
        return currService.deleteCurr(curr);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delCurrList")
    public ResponseEntity<Curr> delCurrList(@RequestBody List<Curr> currs) {
        return currService.deleteCurrList(currs);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Curr> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return currService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Curr curr){
        return currService.exportExcel(curr);
    }
}
