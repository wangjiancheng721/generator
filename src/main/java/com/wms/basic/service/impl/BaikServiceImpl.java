package com.wms.basic.service.impl;

import com.wjc.generator.util.HandleExcel;
import com.wms.basic.entity.Baik;
import com.wms.basic.mapper.BaikMapper;
import com.wms.basic.service.IBaikService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjc.generator.entity.ResponseEntity;
import com.wjc.generator.util.ResponseUtil;
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
public class BaikServiceImpl extends ServiceImpl<BaikMapper, Baik> implements IBaikService {

    @Autowired
    private BaikMapper baikMapper;

    @Override
    public ResponseEntity<Baik> getBaikList(Baik baik,Page page){
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        QueryWrapper queryWrapper = new QueryWrapper(baik);
        page = baikMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Baik> getBaikById(Baik baik){
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        QueryWrapper queryWrapper = new QueryWrapper(baik);
        baik = baikMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(baik);
        return result;
    }

    @Override
    public ResponseEntity<Baik> updateBaik(Baik baik){
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        Integer count = baikMapper.updateById(baik);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Baik> insertBaik(Baik baik){
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        Integer count = baikMapper.insert(baik);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Baik> insertBatch(List<Baik> baiks){
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        Integer count = 0;
        for(Baik baik : baiks){
            baikMapper.insert(baik);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Baik> deleteBaik(Baik baik){
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        Integer count = baikMapper.deleteById(baik);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Baik> deleteBaikList(List<Baik> baiks) {
        ResponseEntity<Baik> result = new ResponseEntity<Baik>();
        Integer count = baikMapper.deleteBatchIds(baiks);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Baik> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Baik baik = new Baik();
            baik.setCode(rows.get(0));
            baik.setCcode(rows.get(1));
            baik.setCust(rows.get(2));
            baik.setTdate(rows.get(3));
            baik.setEdate(rows.get(4));
            baik.setTvol(Double.valueOf(rows.get(5)));
            baik.setPrice(Double.valueOf(rows.get(6)));
            baik.setAprice(Double.valueOf(rows.get(7)));
            baik.setTaxrate(Double.valueOf(rows.get(8)));
            baik.setTaxkubu(Integer.getInteger(rows.get(9)));
            baik.setSousuuout(Double.valueOf(rows.get(10)));
            baik.setSououtkingaku(Double.valueOf(rows.get(11)));
            baik.setFdate(rows.get(12));
            baik.setHokan(rows.get(13));
            baik.setNote(rows.get(14));
            baik.setSysnote(rows.get(15));
            int insert = baikMapper.insert(baik);
        }
        return null;
    }

    @Override
    public String exportExcel(Baik searchBaik) {
        QueryWrapper queryWrapper = new QueryWrapper(searchBaik);
        List<Baik> baiks = baikMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "baiks";
        firstCell.put(0, "发料单号");
        firstCell.put(1, "物料编码");
        firstCell.put(2, "物料品番");
        firstCell.put(3, "来源仓");
        firstCell.put(4, "目标仓");
        firstCell.put(5, "发料数量");
        firstCell.put(6, "计划发料日期");
        firstCell.put(7, "实绩数量");
        firstCell.put(8, "实绩发料日期");
        firstCell.put(9, "状态");
        firstCell.put(10, "计划发料日期");
        firstCell.put(11, "实绩数量");
        firstCell.put(12, "实绩发料日期");
        firstCell.put(13, "状态");
        firstCell.put(14, "实绩发料日期");
        firstCell.put(15, "状态");
        if (baiks.size() > 0) {
            for (Baik baik : baiks){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, baik.getCode());
                contentCell.put(1, baik.getCcode());
                contentCell.put(2, baik.getCust());
                contentCell.put(3, baik.getTdate());
                contentCell.put(4, baik.getEdate());
                contentCell.put(5, baik.getTvol());
                contentCell.put(6, baik.getPrice());
                contentCell.put(7, baik.getAprice());
                contentCell.put(8, baik.getTaxrate());
                contentCell.put(9, baik.getTaxkubu());
                contentCell.put(10, baik.getSousuuout());
                contentCell.put(11, baik.getSououtkingaku());
                contentCell.put(12, baik.getFdate());
                contentCell.put(13, baik.getHokan());
                contentCell.put(14, baik.getNote());
                contentCell.put(15, baik.getSysnote());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }

}
