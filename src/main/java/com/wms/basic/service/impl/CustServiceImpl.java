package com.wms.basic.service.impl;

import com.wjc.generator.util.HandleExcel;
import com.wms.basic.entity.Cust;
import com.wms.basic.entity.Cust;
import com.wms.basic.mapper.CustMapper;
import com.wms.basic.service.ICustService;
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
public class CustServiceImpl extends ServiceImpl<CustMapper, Cust> implements ICustService {

    @Autowired
    private CustMapper custMapper;

    @Override
    public ResponseEntity<Cust> getCustList(Cust cust,Page page){
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        QueryWrapper queryWrapper = new QueryWrapper(cust);
        page = custMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Cust> getCustById(Cust cust){
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        QueryWrapper queryWrapper = new QueryWrapper(cust);
        cust = custMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(cust);
        return result;
    }

    @Override
    public ResponseEntity<Cust> updateCust(Cust cust){
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        Integer count = custMapper.updateById(cust);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Cust> insertCust(Cust cust){
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        Integer count = custMapper.insert(cust);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Cust> insertBatch(List<Cust> custs){
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        Integer count = 0;
        for(Cust cust : custs){
            custMapper.insert(cust);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Cust> deleteCust(Cust cust){
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        Integer count = custMapper.deleteById(cust);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public  ResponseEntity<Cust> deleteCustList(List<Cust> custs) {
        ResponseEntity<Cust> result = new ResponseEntity<Cust>();
        Integer count = custMapper.deleteBatchIds(custs);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Cust> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Cust cust = new Cust();
            cust.setCust(rows.get(0));
            cust.setSkytermsm(Integer.valueOf(rows.get(1)));
            cust.setSkytermsd(Integer.valueOf(rows.get(2)));
            cust.setTaxh(Integer.valueOf(rows.get(3)));
            cust.setCname(rows.get(4));
            cust.setDesname(rows.get(5));
            cust.setDesnamegenp(rows.get(6));
            cust.setDesnameskyu(rows.get(7));
            cust.setCalen(Integer.valueOf(rows.get(8)));
            cust.setYlead(Double.valueOf(rows.get(9)));
            cust.setDelnaijikikan(Integer.valueOf(rows.get(10)));
            cust.setOvertake(Double.valueOf(rows.get(11)));
            cust.setHasuugaku(Integer.valueOf(rows.get(12)));
            cust.setHasuutax(Integer.valueOf(rows.get(13)));
            cust.setBunrc(rows.get(14));
            cust.setBusho(rows.get(15));
            cust.setHito(rows.get(16));
            cust.setTel(rows.get(17));
            cust.setFax(rows.get(18));
            cust.setSime(Integer.valueOf(rows.get(19)));
            cust.setLastsimedate(rows.get(20));
            cust.setKamoku(rows.get(21));
            cust.setCurre(rows.get(22));
            cust.setZip(rows.get(23));
            cust.setAdr1(rows.get(24));
            cust.setAdr2(rows.get(25));
            cust.setMail(rows.get(26));
            cust.setNote(rows.get(27));
            cust.setCustku(Integer.valueOf(rows.get(28)));
            cust.setLinkcust(rows.get(29));
            int insert = custMapper.insert(cust);
        }
        return null;
    }

    @Override
    public String exportExcel(Cust searchCust) {
        QueryWrapper queryWrapper = new QueryWrapper(searchCust);
        List<Cust> custs = custMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "custs";
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
        if (custs.size() > 0) {
            for (Cust cust : custs){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, cust.getCust());
                contentCell.put(1, cust.getSkytermsm());
                contentCell.put(2, cust.getSkytermsd());
                contentCell.put(3, cust.getTaxh());
                contentCell.put(4, cust.getCname());
                contentCell.put(5, cust.getDesname());
                contentCell.put(6, cust.getDesnamegenp());
                contentCell.put(7, cust.getDesnameskyu());
                contentCell.put(8, cust.getCalen());
                contentCell.put(9, cust.getYlead());
                contentCell.put(10, cust.getDelnaijikikan());
                contentCell.put(11, cust.getOvertake());
                contentCell.put(12, cust.getHasuugaku());
                contentCell.put(13, cust.getHasuutax());
                contentCell.put(14, cust.getBunrc());
                contentCell.put(15, cust.getBusho());
                contentCell.put(16, cust.getHito());
                contentCell.put(17, cust.getTel());
                contentCell.put(18, cust.getFax());
                contentCell.put(19, cust.getSime());
                contentCell.put(20, cust.getLastsimedate());
                contentCell.put(21, cust.getKamoku());
                contentCell.put(22, cust.getCurre());
                contentCell.put(23, cust.getZip());
                contentCell.put(24, cust.getAdr1());
                contentCell.put(25, cust.getAdr2());
                contentCell.put(26, cust.getMail());
                contentCell.put(27, cust.getNote());
                contentCell.put(28, cust.getCustku());
                contentCell.put(29, cust.getLinkcust());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }
}
