package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.wms.basic.entity.Tank;
import com.wms.basic.service.impl.TankServiceImpl;
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
@RequestMapping("/tank")
public class TankController {

    @Autowired
    private TankServiceImpl tankService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getTankList")
    public ResponseEntity<Tank> getTankList(@RequestBody Tank tank) {
        Page<Tank> page = new Page<Tank>(tank.getPageNo(),tank.getPageSize());
        return tankService.getTankList(tank,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getTankById")
    public ResponseEntity<Tank> getTankById(@RequestBody Tank tank) {
        return tankService.getTankById(tank);
    }

    /**
     * 新增
     */
    @PostMapping("/insertTank")
    public ResponseEntity<Tank> insertTank(@RequestBody Tank tank) {
        return tankService.insertTank(tank);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Tank> insertBatch(@RequestBody List<Tank> tanks) {
        return tankService.insertBatch(tanks);
    }

    /**
     * 更新
     */
    @PostMapping("/updateTank")
    public ResponseEntity<Tank> updateTank(@RequestBody Tank tank) {
        return tankService.updateTank(tank);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delTank")
    public ResponseEntity<Tank> delTank(@RequestBody Tank tank) {
        return tankService.deleteTank(tank);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delTankList")
    public ResponseEntity<Tank> delTankList(@RequestBody List<Tank> tanks) {
        return tankService.deleteTankList(tanks);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Tank> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return tankService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Tank tank){
        return tankService.exportExcel(tank);
    }

}
