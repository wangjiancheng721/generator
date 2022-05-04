package com.wms.basic.service.impl;

import com.wms.basic.entity.Cust;
import com.wms.basic.entity.Head;
import com.wms.basic.entity.Prts;
import com.wms.basic.entity.ResponseEntity;
import com.wms.basic.mapper.PrtsMapper;
import com.wms.basic.service.IPrtsService;
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
public class PrtsServiceImpl extends ServiceImpl<PrtsMapper, Prts> implements IPrtsService {

    @Autowired
    private PrtsMapper prtsMapper;

    @Override
    public ResponseEntity<Prts> getPrtsList(Prts prts, Page page){
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        QueryWrapper queryWrapper = new QueryWrapper(prts);
        page = prtsMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Prts> getPrtsById(Prts prts){
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        QueryWrapper queryWrapper = new QueryWrapper(prts);
        prts = prtsMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(prts);
        return result;
    }

    @Override
    public ResponseEntity<Prts> updatePrts(Prts prts){
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        Integer count = prtsMapper.updateById(prts);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Prts> insertPrts(Prts prts){
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        Integer count = prtsMapper.insert(prts);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Prts> insertBatch(List<Prts> prtss){
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        Integer count = 0;
        for(Prts prts : prtss){
            prtsMapper.insert(prts);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Prts> deletePrts(Prts prts){
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        Integer count = prtsMapper.deleteById(prts);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public  ResponseEntity<Prts> deletePrtsList(List<Prts> prtss) {
        ResponseEntity<Prts> result = new ResponseEntity<Prts>();
        Integer count = prtsMapper.deleteBatchIds(prtss);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Prts> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Prts prts = new Prts();
            prts.setCode(rows.get(0));
            prts.setRev(rows.get(1));
            prts.setChggrp(rows.get(2));
            prts.setKcode(rows.get(3));
            prts.setKeda(Integer.valueOf(rows.get(4)));
            prts.setBumo(rows.get(5));
            prts.setOpt(rows.get(6));
            prts.setSiyou(Double.valueOf(rows.get(7)));
            prts.setSiyouw(Double.valueOf(rows.get(8)));
            prts.setSiyouf(Double.valueOf(rows.get(9)));
            prts.setFuryou(Double.valueOf(rows.get(10)));
            prts.setSdate(rows.get(11));
            prts.setEdate(rows.get(12));
            prts.setNokanri(Integer.valueOf(rows.get(13)));
            prts.setNote(rows.get(14));
            prts.setSysnote(rows.get(15));
            int insert = prtsMapper.insert(prts);
        }
        return null;
    }

    @Override
    public String exportExcel(Prts searchPrts) {
        QueryWrapper queryWrapper = new QueryWrapper(searchPrts);
        List<Prts> prtss = prtsMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "prtss";
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
        firstCell.put(15, "计划发料日期");
        if (prtss.size() > 0) {
            for (Prts prts : prtss){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, prts.getCode());
                contentCell.put(1, prts.getRev());
                contentCell.put(2, prts.getChggrp());
                contentCell.put(3, prts.getKcode());
                contentCell.put(4, prts.getKeda());
                contentCell.put(5, prts.getBumo());
                contentCell.put(6, prts.getOpt());
                contentCell.put(7, prts.getSiyou());
                contentCell.put(8, prts.getSiyouw());
                contentCell.put(9, prts.getSiyouf());
                contentCell.put(10, prts.getFuryou());
                contentCell.put(11, prts.getSdate());
                contentCell.put(12, prts.getEdate());
                contentCell.put(13, prts.getNokanri());
                contentCell.put(14, prts.getNote());
                contentCell.put(15, prts.getSysnote());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }
}
