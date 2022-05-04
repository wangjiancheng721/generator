package com.wms.basic.service.impl;

import com.wms.basic.entity.ResponseEntity;
import com.wms.basic.entity.Tank;
import com.wms.basic.mapper.TankMapper;
import com.wms.basic.service.ITankService;
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
public class TankServiceImpl extends ServiceImpl<TankMapper, Tank> implements ITankService {

    @Autowired
    private TankMapper tankMapper;

    @Override
    public ResponseEntity<Tank> getTankList(Tank tank, Page page){
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        QueryWrapper queryWrapper = new QueryWrapper(tank);
        page = tankMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Tank> getTankById(Tank tank){
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        QueryWrapper queryWrapper = new QueryWrapper(tank);
        tank = tankMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(tank);
        return result;
    }

    @Override
    public ResponseEntity<Tank> updateTank(Tank tank){
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        Integer count = tankMapper.updateById(tank);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Tank> insertTank(Tank tank){
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        Integer count = tankMapper.insert(tank);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Tank> insertBatch(List<Tank> tanks){
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        Integer count = 0;
        for(Tank tank : tanks){
            tankMapper.insert(tank);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Tank> deleteTank(Tank tank){
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        Integer count = tankMapper.deleteById(tank);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public  ResponseEntity<Tank> deleteTankList(List<Tank> tanks) {
        ResponseEntity<Tank> result = new ResponseEntity<Tank>();
        Integer count = tankMapper.deleteBatchIds(tanks);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Tank> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Tank tank = new Tank();
            tank.setTid(Integer.valueOf(rows.get(0)));
            tank.setCode(rows.get(1));
            tank.setVcode(rows.get(2));
            tank.setVendor(rows.get(3));
            tank.setWcode(rows.get(4));
            tank.setMakername(rows.get(5));
            tank.setTdate(rows.get(6));
            tank.setEdate(rows.get(7));
            tank.setTvol(Double.valueOf(rows.get(8)));
            tank.setTema(Integer.valueOf(rows.get(9)));
            tank.setSprice(Double.valueOf(rows.get(10)));
            tank.setPrice(Double.valueOf(rows.get(11)));
            tank.setTaxrate(Double.valueOf(rows.get(12)));
            tank.setTaxkubu(Integer.valueOf(rows.get(13)));
            tank.setSoukingaku(Double.valueOf(rows.get(14)));
            tank.setSousuuin(Double.valueOf(rows.get(15)));
            tank.setAprice(Double.valueOf(rows.get(16)));
            tank.setHokan(rows.get(17));
            tank.setNote(rows.get(18));
            tank.setSysnote(rows.get(19));
            int insert = tankMapper.insert(tank);
        }
        return null;
    }

    @Override
    public String exportExcel(Tank searchTank) {
        QueryWrapper queryWrapper = new QueryWrapper(searchTank);
        List<Tank> tanks = tankMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "tanks";
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
        firstCell.put(16, "实绩发料日期");
        firstCell.put(17, "状态");
        firstCell.put(18, "实绩发料日期");
        firstCell.put(19, "状态");
        if (tanks.size() > 0) {
            for (Tank tank : tanks){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, tank.getTid());
                contentCell.put(1, tank.getCode());
                contentCell.put(2, tank.getVcode());
                contentCell.put(3, tank.getVendor());
                contentCell.put(4, tank.getWcode());
                contentCell.put(5, tank.getMakername());
                contentCell.put(6, tank.getTdate());
                contentCell.put(7, tank.getEdate());
                contentCell.put(8, tank.getTvol());
                contentCell.put(9, tank.getTema());
                contentCell.put(10, tank.getSprice());
                contentCell.put(11, tank.getPrice());
                contentCell.put(12, tank.getTaxrate());
                contentCell.put(13, tank.getTaxkubu());
                contentCell.put(14, tank.getSoukingaku());
                contentCell.put(15, tank.getSousuuin());
                contentCell.put(16, tank.getAprice());
                contentCell.put(17, tank.getHokan());
                contentCell.put(18, tank.getNote());
                contentCell.put(19, tank.getSysnote());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }
}
