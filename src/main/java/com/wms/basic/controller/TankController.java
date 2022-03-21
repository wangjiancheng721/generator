package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Tank;
import com.wms.basic.service.impl.TankServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
@RestController
@RequestMapping("/tank")
public class TankController {

    @Autowired
    private TankServiceImpl tankService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getTankList")
    public Object getTankList(@RequestBody Tank tank) {
        return tankService.getTankList(tank);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getTankById")
    public Tank getTankById(@RequestBody Tank tank) {
        return tankService.getTankById(tank);
    }

    /**
     * 新增
     */
    @PostMapping("/insertTank")
    public void insertTank(@RequestBody Tank tank) {
        tankService.insertTank(tank);
    }

    /**
     * 更新
     */
    @PostMapping("/updateTank")
    public void updateTank(@RequestBody Tank tank) {
        tankService.updateTank(tank);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delTank")
    public void delTank(@RequestBody Tank tank) {
        tankService.deleteTank(tank);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delTankList")
    public void delTankList(@RequestBody List<Tank> tanks) {
        tankService.deleteTankList(tanks);
    }

}
