package com.wms.basic.service.impl;

import com.wjc.generator.util.HandleExcel;
import com.wms.basic.entity.Sect;
import com.wms.basic.mapper.SectMapper;
import com.wms.basic.service.ISectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
public class SectServiceImpl extends ServiceImpl<SectMapper, Sect> implements ISectService {

    @Autowired
    private SectMapper sectMapper;

    @Override
    public ResponseEntity<Sect> getSectList(Sect sect,Page page){
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        QueryWrapper queryWrapper = new QueryWrapper(sect);
        page = sectMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Sect> getSectById(Sect sect){
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        QueryWrapper queryWrapper = new QueryWrapper(sect);
        sect = sectMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(sect);
        return result;
    }

    @Override
    public ResponseEntity<Sect> updateSect(Sect sect){
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        Integer count = sectMapper.updateById(sect);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Sect> insertSect(Sect sect){
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        Integer count = sectMapper.insert(sect);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Sect> insertBatch(List<Sect> sects){
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        Integer count = 0;
        for(Sect sect : sects){
            sectMapper.insert(sect);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Sect> deleteSect(Sect sect){
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        Integer count = sectMapper.deleteById(sect);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public  ResponseEntity<Sect> deleteSectList(List<Sect> sects) {
        ResponseEntity<Sect> result = new ResponseEntity<Sect>();
        Integer count = sectMapper.deleteBatchIds(sects);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Sect> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Sect sect = new Sect();
            sect.setBumo(rows.get(0));
            sect.setBname(rows.get(1));
            sect.setDesname(rows.get(2));
            sect.setDesnamegenp(rows.get(3));
            sect.setGku(Integer.valueOf(rows.get(4)));
            sect.setCalen(Integer.valueOf(rows.get(5)));
            sect.setCalepowern(Integer.valueOf(rows.get(6)));
            sect.setSortorder(Integer.valueOf(rows.get(7)));
            sect.setBunrs(rows.get(8));
            sect.setBusho(rows.get(9));
            sect.setPower(Double.valueOf(rows.get(10)));
            sect.setRate(Double.valueOf(rows.get(11)));
            sect.setArate(Double.valueOf(rows.get(12)));
            sect.setYrate(Double.valueOf(rows.get(13)));
            sect.setDoflat(Integer.valueOf(rows.get(14)));
            sect.setBfnorma(Double.valueOf(rows.get(15)));
            sect.setToujitu(Double.valueOf(rows.get(16)));
            sect.setNorma(Double.valueOf(rows.get(17)));
            sect.setCountorder(Integer.valueOf(rows.get(18)));
            sect.setCountokure(Integer.valueOf(rows.get(19)));
            sect.setCountsusumi(Integer.valueOf(rows.get(20)));
            sect.setWeb(Integer.valueOf(rows.get(21)));
            sect.setNoansterm(Integer.valueOf(rows.get(22)));
            sect.setMailterm(Integer.valueOf(rows.get(23)));
            sect.setDenppattern(rows.get(24));
            sect.setTanksearchku(Integer.valueOf(rows.get(25)));
            sect.setHasuugaku(Integer.valueOf(rows.get(26)));
            sect.setHasuutax(Integer.valueOf(rows.get(27)));
            sect.setLastsimedate(rows.get(28));
            sect.setHito(rows.get(29));
            sect.setTel(rows.get(30));
            sect.setFax(rows.get(31));
            sect.setSime(Integer.valueOf(rows.get(32)));
            sect.setKamoku(rows.get(33));
            sect.setCurre(rows.get(34));
            sect.setZip(rows.get(35));
            sect.setAdr1(rows.get(36));
            sect.setAdr2(rows.get(37));
            sect.setMail(rows.get(38));
            sect.setPayeecode(rows.get(39));
            sect.setNote(rows.get(40));
            sect.setSysnote(rows.get(41));
            sect.setSectku(Integer.valueOf(rows.get(42)));
            int insert = sectMapper.insert(sect);
        }
        return null;
    }

    @Override
    public String exportExcel(Sect searchSect) {
        QueryWrapper queryWrapper = new QueryWrapper(searchSect);
        List<Sect> sects = sectMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "sects";
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
        firstCell.put(16, "实绩数量");
        firstCell.put(17, "实绩发料日期");
        firstCell.put(18, "发料单号");
        firstCell.put(19, "物料编码");
        firstCell.put(20, "物料品番");
        firstCell.put(21, "来源仓");
        firstCell.put(22, "目标仓");
        firstCell.put(23, "发料数量");
        firstCell.put(24, "计划发料日期");
        firstCell.put(25, "实绩数量");
        firstCell.put(26, "实绩发料日期");
        firstCell.put(27, "发料单号");
        firstCell.put(28, "物料编码");
        firstCell.put(29, "物料品番");
        firstCell.put(30, "发料单号");
        firstCell.put(31, "物料编码");
        firstCell.put(32, "物料品番");
        firstCell.put(33, "来源仓");
        firstCell.put(34, "目标仓");
        firstCell.put(35, "发料数量");
        firstCell.put(36, "计划发料日期");
        firstCell.put(37, "实绩数量");
        firstCell.put(38, "实绩发料日期");
        firstCell.put(39, "发料单号");
        firstCell.put(40, "物料编码");
        firstCell.put(41, "物料品番");
        firstCell.put(42, "来源仓");
        if (sects.size() > 0) {
            for (Sect sect : sects){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, sect.getBumo());
                contentCell.put(1, sect.getBname());
                contentCell.put(2, sect.getDesname());
                contentCell.put(3, sect.getDesnamegenp());
                contentCell.put(4, sect.getGku());
                contentCell.put(5, sect.getCalen());
                contentCell.put(6, sect.getCalepowern());
                contentCell.put(7, sect.getSortorder());
                contentCell.put(8, sect.getBunrs());
                contentCell.put(9, sect.getBusho());
                contentCell.put(10, sect.getPower());
                contentCell.put(11, sect.getRate());
                contentCell.put(12, sect.getArate());
                contentCell.put(13, sect.getYrate());
                contentCell.put(14, sect.getDoflat());
                contentCell.put(15, sect.getBfnorma());
                contentCell.put(16, sect.getToujitu());
                contentCell.put(17, sect.getNorma());
                contentCell.put(18, sect.getCountorder());
                contentCell.put(19, sect.getCountokure());
                contentCell.put(20, sect.getCountsusumi());
                contentCell.put(21, sect.getWeb());
                contentCell.put(22, sect.getNoansterm());
                contentCell.put(23, sect.getMailterm());
                contentCell.put(24, sect.getDenppattern());
                contentCell.put(25, sect.getTanksearchku());
                contentCell.put(26, sect.getHasuugaku());
                contentCell.put(27, sect.getHasuutax());
                contentCell.put(28, sect.getLastsimedate());
                contentCell.put(29, sect.getHito());
                contentCell.put(30, sect.getTel());
                contentCell.put(31, sect.getFax());
                contentCell.put(32, sect.getSime());
                contentCell.put(33, sect.getKamoku());
                contentCell.put(34, sect.getCurre());
                contentCell.put(35, sect.getZip());
                contentCell.put(36, sect.getAdr1());
                contentCell.put(37, sect.getAdr2());
                contentCell.put(38, sect.getMail());
                contentCell.put(39, sect.getPayeecode());
                contentCell.put(40, sect.getNote());
                contentCell.put(41, sect.getSysnote());
                contentCell.put(42, sect.getSectku());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }
}
