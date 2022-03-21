package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Curr;
import com.wms.basic.service.impl.CurrServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
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
    public Object getCurrList(@RequestBody Curr curr) {
        return currService.getCurrList(curr);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getCurrById")
    public Curr getCurrById(@RequestBody Curr curr) {
        return currService.getCurrById(curr);
    }

    /**
     * 新增
     */
    @PostMapping("/insertCurr")
    public void insertCurr(@RequestBody Curr curr) {
        currService.insertCurr(curr);
    }

    /**
     * 更新
     */
    @PostMapping("/updateCurr")
    public void updateCurr(@RequestBody Curr curr) {
        currService.updateCurr(curr);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delCurr")
    public void delCurr(@RequestBody Curr curr) {
        currService.deleteCurr(curr);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delCurrList")
    public void delCurrList(@RequestBody List<Curr> currs) {
        currService.deleteCurrList(currs);
    }

}
