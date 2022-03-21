package com.wms.basic.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.wms.basic.entity.Head;
import com.wms.basic.service.impl.HeadServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
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
    public Object getHeadList(@RequestBody Head head) {
        return headService.getHeadList(head);
    }

    /**
    * 根据id获取信息
    */
    @PostMapping("/getHeadById")
    public Head getHeadById(@RequestBody Head head) {
        return headService.getHeadById(head);
    }

    /**
     * 新增
     */
    @PostMapping("/insertHead")
    public void insertHead(@RequestBody Head head) {
        headService.insertHead(head);
    }

    /**
     * 更新
     */
    @PostMapping("/updateHead")
    public void updateHead(@RequestBody Head head) {
        headService.updateHead(head);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/delHead")
    public void delHead(@RequestBody Head head) {
        headService.deleteHead(head);
    }

    /**
     * 根据id列表批量删除
     */
    @DeleteMapping("/delHeadList")
    public void delHeadList(@RequestBody List<Head> heads) {
        headService.deleteHeadList(heads);
    }

}
