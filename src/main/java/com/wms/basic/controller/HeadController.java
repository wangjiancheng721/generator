package com.wms.basic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.entity.Cust;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wjc.generator.entity.ResponseEntity;
import com.wms.basic.entity.Head;
import com.wms.basic.service.impl.HeadServiceImpl;
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
@RequestMapping("/head")
public class HeadController {

    @Autowired
    private HeadServiceImpl headService;

    /**
    * 分页获取列表
    */
    @PostMapping("/getHeadList")
    public ResponseEntity<Head> getHeadList(@RequestBody Head head) {
        Page<Head> page = new Page<Head>(head.getPageNo(),head.getPageSize());
        return headService.getHeadList(head,page);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getHeadById")
    public ResponseEntity<Head> getHeadById(@RequestBody Head head) {
        return headService.getHeadById(head);
    }

    /**
     * 新增
     */
    @PostMapping("/insertHead")
    public ResponseEntity<Head> insertHead(@RequestBody Head head) {
        return headService.insertHead(head);
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertBatch")
    public ResponseEntity<Head> insertBatch(@RequestBody List<Head> heads) {
        return headService.insertBatch(heads);
    }

    /**
     * 更新
     */
    @PostMapping("/updateHead")
    public ResponseEntity<Head> updateHead(@RequestBody Head head) {
        return headService.updateHead(head);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delHead")
    public ResponseEntity<Head> delHead(@RequestBody Head head) {
        return headService.deleteHead(head);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delHeadList")
    public ResponseEntity<Head> delHeadList(@RequestBody List<Head> heads) {
        return headService.deleteHeadList(heads);
    }

    @PostMapping("/importExcel")
    public ResponseEntity<Head> importExcel(@RequestParam("file") MultipartFile uploadFile){
        return headService.importExcel(uploadFile);
    }

    @PostMapping("/exportExcel")
    public String exportExcel(@RequestBody Head head){
        return headService.exportExcel(head);
    }

}
