package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Prts;
import com.wms.basic.service.impl.PrtsServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
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
    public Object getPrtsList(@RequestBody Prts prts) {
        return prtsService.getPrtsList(prts);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getPrtsById")
    public Prts getPrtsById(@RequestBody Prts prts) {
        return prtsService.getPrtsById(prts);
    }

    /**
     * 新增
     */
    @PostMapping("/insertPrts")
    public void insertPrts(@RequestBody Prts prts) {
        prtsService.insertPrts(prts);
    }

    /**
     * 更新
     */
    @PostMapping("/updatePrts")
    public void updatePrts(@RequestBody Prts prts) {
        prtsService.updatePrts(prts);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delPrts")
    public void delPrts(@RequestBody Prts prts) {
        prtsService.deletePrts(prts);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delPrtsList")
    public void delPrtsList(@RequestBody List<Prts> prtss) {
        prtsService.deletePrtsList(prtss);
    }

}
