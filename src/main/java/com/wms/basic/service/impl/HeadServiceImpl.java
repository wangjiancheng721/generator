package com.wms.basic.service.impl;

import com.wms.basic.entity.Head;
import com.wms.basic.entity.Head;
import com.wms.basic.entity.ResponseEntity;
import com.wms.basic.mapper.HeadMapper;
import com.wms.basic.service.IHeadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.basic.util.HandleExcel;
import com.wms.basic.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wjc
 * @since 2022-03-22
 */
@Transactional
@Service
public class HeadServiceImpl extends ServiceImpl<HeadMapper, Head> implements IHeadService {

    @Autowired
    private HeadMapper headMapper;

    @Override
    public ResponseEntity<Head> getHeadList(Head head,Page page){
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        QueryWrapper queryWrapper = new QueryWrapper(head);
        page = headMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Head> getHeadById(Head head){
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        QueryWrapper queryWrapper = new QueryWrapper(head);
        head = headMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(head);
        return result;
    }

    @Override
    public ResponseEntity<Head> updateHead(Head head){
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        Integer count = headMapper.updateById(head);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Head> insertHead(Head head){
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        Integer count = headMapper.insert(head);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Head> insertBatch(List<Head> heads){
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        Integer count = 0;
        for(Head head : heads){
            headMapper.insert(head);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Head> deleteHead(Head head){
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        Integer count = headMapper.deleteById(head);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Head> deleteHeadList(List<Head> heads) {
        ResponseEntity<Head> result = new ResponseEntity<Head>();
        Integer count = headMapper.deleteBatchIds(heads);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Head> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Head head = new Head();
            head.setCode(rows.get(0));
            head.setName(rows.get(1));
            head.setMainbumo(rows.get(2));
            head.setDofukusuu(Integer.valueOf(rows.get(3)));
            head.setDoseiban(Integer.valueOf(rows.get(1)));
            head.setSeibhku(Integer.valueOf(rows.get(1)));
            head.setDorirekioya(Integer.valueOf(rows.get(1)));
            head.setDorirekiko(Integer.valueOf(rows.get(1)));
            head.setDolot(Integer.valueOf(rows.get(8)));
            head.setProjonly(Integer.valueOf(rows.get(9)));
            head.setTani1(rows.get(10));
            head.setOyak(Integer.valueOf(rows.get(11)));
            head.setNote(rows.get(12));
            head.setSysnote(rows.get(13));
            head.setPlantid(rows.get(14));
            int insert = headMapper.insert(head);
        }
        return null;
    }

    @Override
    public String exportExcel(Head searchHead) {
        QueryWrapper queryWrapper = new QueryWrapper(searchHead);
        List<Head> heads = headMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "heads";
        firstCell.put(0, "发料单号");
        firstCell.put(1, "物料编码");
        firstCell.put(2, "物料品番");
        firstCell.put(3, "来源仓");
        firstCell.put(4, "目标仓");
        firstCell.put(5, "发料数量");
        firstCell.put(6, "计划发料日期");
        firstCell.put(7, "实绩数量");
        firstCell.put(8, "实绩发料日期");
        firstCell.put(9, "发料单号");
        firstCell.put(10, "物料编码");
        firstCell.put(11, "物料品番");
        firstCell.put(12, "来源仓");
        firstCell.put(13, "目标仓");
        firstCell.put(14, "发料数量");
        if (heads.size() > 0) {
            for (Head head : heads){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, head.getCode());
                contentCell.put(1, head.getName());
                contentCell.put(2, head.getMainbumo());
                contentCell.put(3, head.getDofukusuu());
                contentCell.put(4, head.getDoseiban());
                contentCell.put(5, head.getSeibhku());
                contentCell.put(6, head.getDorirekioya());
                contentCell.put(7, head.getDorirekiko());
                contentCell.put(8, head.getDolot());
                contentCell.put(9, head.getProjonly());
                contentCell.put(10, head.getTani1());
                contentCell.put(11, head.getOyak());
                contentCell.put(12, head.getNote());
                contentCell.put(13, head.getSysnote());
                contentCell.put(14, head.getPlantid());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }


}
