package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Cust;
import com.wms.basic.service.impl.CustServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-20
 */
@RestController
@RequestMapping("/cust")
public class CustController {

    @Autowired
    private CustServiceImpl custService;

    /**
    * 分页获取列表
    */
    @GetMapping("/getCustList(Cust")
    public Object getCustList(Cust cust) {
        return custService.getCustList(cust);
    }

    /**
    * 根据id获取信息
    */
    @GetMapping("/getCustById")
    public Cust getCustById(@RequestBody Cust cust) {
        return custService.getCustById(cust);
    }

    /**
     * 新增
     */
    @PostMapping("/insertCust")
    public void insertCust(@RequestBody Cust cust) {
        custService.insertCust(cust);
    }

    /**
     * 更新
     */
    @PostMapping("/updateCust")
    public void updateCust(@RequestBody Cust cust) {
        custService.updateCust(cust);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delCust")
    public void delCust(@RequestBody Cust cust) {
        custService.deleteCust(cust);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delCustList")
    public void delCustList(@RequestBody List<Cust> custs) {
        custService.deleteCustList(custs);
    }

}
