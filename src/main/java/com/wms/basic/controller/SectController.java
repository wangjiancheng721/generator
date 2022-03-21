package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Sect;
import com.wms.basic.service.impl.SectServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
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
    public Object getSectList(@RequestBody Sect sect) {
        return sectService.getSectList(sect);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getSectById")
    public Sect getSectById(@RequestBody Sect sect) {
        return sectService.getSectById(sect);
    }

    /**
     * 新增
     */
    @PostMapping("/insertSect")
    public void insertSect(@RequestBody Sect sect) {
        sectService.insertSect(sect);
    }

    /**
     * 更新
     */
    @PostMapping("/updateSect")
    public void updateSect(@RequestBody Sect sect) {
        sectService.updateSect(sect);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delSect")
    public void delSect(@RequestBody Sect sect) {
        sectService.deleteSect(sect);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delSectList")
    public void delSectList(@RequestBody List<Sect> sects) {
        sectService.deleteSectList(sects);
    }

}
