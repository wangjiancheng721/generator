package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Baik;
import com.wms.basic.service.impl.BaikServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-20
 */
@RestController
@RequestMapping("/baik")
public class BaikController {

    @Autowired
    private BaikServiceImpl baikService;

    /**
    * 分页获取列表
    */
    @GetMapping("/getBaikList(Baik")
    public Object getBaikList(Baik baik) {
        return baikService.getBaikList(baik);
    }

    /**
    * 根据id获取信息
    */
    @GetMapping("/getBaikById")
    public Baik getBaikById(@RequestBody Baik baik) {
        return baikService.getBaikById(baik);
    }

    /**
     * 新增
     */
    @PostMapping("/insertBaik")
    public void insertBaik(@RequestBody Baik baik) {
        baikService.insertBaik(baik);
    }

    /**
     * 更新
     */
    @PostMapping("/updateBaik")
    public void updateBaik(@RequestBody Baik baik) {
        baikService.updateBaik(baik);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delBaik")
    public void delBaik(@RequestBody Baik baik) {
        baikService.deleteBaik(baik);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delBaikList")
    public void delBaikList(@RequestBody List<Baik> baiks) {
        baikService.deleteBaikList(baiks);
    }

}
