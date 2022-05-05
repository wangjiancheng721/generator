package com.wms.basic.service.impl;

import com.wms.basic.entity.Baik;
import com.wms.basic.entity.Curr;
import com.wms.basic.entity.ResponseEntity;
import com.wms.basic.mapper.CurrMapper;
import com.wms.basic.service.ICurrService;
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
public class CurrServiceImpl extends ServiceImpl<CurrMapper, Curr> implements ICurrService {

    @Autowired
    private CurrMapper currMapper;

    @Override
    public ResponseEntity<Curr> getCurrList(Curr curr,Page page){
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
        page = currMapper.selectPage(curr, page);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Curr> getCurrById(Curr curr){
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
        curr = currMapper.selectOne(curr);
        result = ResponseUtil.responseSuccess(curr);
        return result;
    }

    @Override
    public ResponseEntity<Curr> updateCurr(Curr curr){
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
        Integer count = currMapper.updateById(curr);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Curr> insertCurr(Curr curr){
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
        Integer count = currMapper.insert(curr);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Curr> insertBatch(List<Curr> currs){
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
//        Integer count = 0;
//        for(Curr curr : currs){
//            currMapper.insert(curr);
//            count++;
//        }
        int count = currMapper.insertBatch(currs);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Curr> deleteCurr(Curr curr){
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
        Integer count = currMapper.deleteById(curr);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public  ResponseEntity<Curr> deleteCurrList(List<Curr> currs) {
        ResponseEntity<Curr> result = new ResponseEntity<Curr>();
        Integer count = currMapper.deleteBatchIds(currs);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Curr> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Curr curr = new Curr();
            curr.setCurre(rows.get(0));
            curr.setTdate(rows.get(1));
            curr.setCrates(Double.valueOf(rows.get(2)));
            curr.setCratef(Double.valueOf(rows.get(3)));
            curr.setCope(rows.get(4));
            curr.setCpointt(Integer.valueOf(rows.get(5)));
            curr.setCpointg(Integer.valueOf(rows.get(6)));
            curr.setNote(rows.get(7));
            curr.setSysnote(rows.get(8));
            int insert = currMapper.insert(curr);
        }
        return null;
    }

    @Override
    public String exportExcel(Curr searchCurr) {
        QueryWrapper queryWrapper = new QueryWrapper(searchCurr);
        List<Curr> currs = currMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "currs";
        firstCell.put(0, "发料单号");
        firstCell.put(1, "物料编码");
        firstCell.put(2, "物料品番");
        firstCell.put(3, "来源仓");
        firstCell.put(4, "目标仓");
        firstCell.put(5, "发料数量");
        firstCell.put(6, "计划发料日期");
        firstCell.put(7, "实绩数量");
        firstCell.put(8, "实绩发料日期");
        if (currs.size() > 0) {
            for (Curr curr : currs){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, curr.getCurre());
                contentCell.put(1, curr.getTdate());
                contentCell.put(2, curr.getCrates());
                contentCell.put(3, curr.getCratef());
                contentCell.put(4, curr.getCope());
                contentCell.put(5, curr.getCpointt());
                contentCell.put(6, curr.getCpointg());
                contentCell.put(7, curr.getNote());
                contentCell.put(8, curr.getSysnote());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }
}
