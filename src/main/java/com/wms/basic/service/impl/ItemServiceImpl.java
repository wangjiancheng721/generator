package com.wms.basic.service.impl;

import com.wjc.generator.util.HandleExcel;
import com.wms.basic.entity.Item;
import com.wms.basic.entity.Head;
import com.wms.basic.entity.Item;
import com.wms.basic.mapper.ItemMapper;
import com.wms.basic.service.IItemService;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ResponseEntity<Item> getItemList(Item item,Page page){
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        QueryWrapper queryWrapper = new QueryWrapper(item);
        page = itemMapper.selectPage(page, queryWrapper);
        result = ResponseUtil.responseSuccess(page.getRecords());
        return result;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public ResponseEntity<Item> getItemById(Item item){
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        QueryWrapper queryWrapper = new QueryWrapper(item);
        item = itemMapper.selectOne(queryWrapper);
        result = ResponseUtil.responseSuccess(item);
        return result;
    }

    @Override
    public ResponseEntity<Item> updateItem(Item item){
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        Integer count = itemMapper.updateById(item);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Item> insertItem(Item item){
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        Integer count = itemMapper.insert(item);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Item> insertBatch(List<Item> items){
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        Integer count = 0;
        for(Item item : items){
            itemMapper.insert(item);
            count++;
        }
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Item> deleteItem(Item item){
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        Integer count = itemMapper.deleteById(item);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public  ResponseEntity<Item> deleteItemList(List<Item> items) {
        ResponseEntity<Item> result = new ResponseEntity<Item>();
        Integer count = itemMapper.deleteBatchIds(items);
        result = ResponseUtil.responseSuccess(count);
        return result;
    }

    @Override
    public ResponseEntity<Item> importExcel(MultipartFile uploadFile) {
        List<Object> importData = new ArrayList<Object>();
        HandleExcel handleExcel = new HandleExcel();
        String fileName = uploadFile.getOriginalFilename();
        importData = handleExcel.importExcel(uploadFile, fileName);
        List<List<String>> sheets = (List) importData.get(0);
        for (List<String> rows : sheets) {
            if (rows.get(0) == null || "".equals(rows.get(0))) {
                continue;
            }
            Item item = new Item();
            item.setCode(rows.get(0));
            item.setBunr(rows.get(1));
            item.setBumo(rows.get(2));
            item.setVendor(rows.get(3));
            item.setFixlevel(Integer.valueOf(rows.get(4)));
            item.setDkaku(Double.valueOf(rows.get(5)));
            item.setKaku(Double.valueOf(rows.get(6)));
            item.setKoteim(Integer.valueOf(rows.get(7)));
            item.setStzaik(Double.valueOf(rows.get(8)));
            item.setLead(Double.valueOf(rows.get(9)));
            item.setKouki(Double.valueOf(rows.get(10)));
            item.setHojyuu(Integer.valueOf(rows.get(11)));
            item.setKuriage(Integer.valueOf(rows.get(12)));
            item.setJcode(rows.get(13));
            item.setKouthiki(Integer.valueOf(rows.get(14)));
            item.setHokan(rows.get(15));
            item.setNextbumo(rows.get(16));
            item.setLoth(Integer.valueOf(rows.get(17)));
            item.setLots(Double.valueOf(rows.get(18)));
            item.setLots2(Double.valueOf(rows.get(19)));
            item.setHimoku(Integer.valueOf(rows.get(20)));
            item.setFuryou(Double.valueOf(rows.get(21)));
            item.setLead2(Double.valueOf(rows.get(22)));
            item.setTanikouki(Double.valueOf(rows.get(23)));
            item.setKouki2(Double.valueOf(rows.get(24)));
            item.setLinkslip(Integer.valueOf(rows.get(25)));
            item.setNokanri(Integer.valueOf(rows.get(26)));
            item.setPickku(Integer.valueOf(rows.get(27)));
            item.setPicklots(Double.valueOf(rows.get(28)));
            item.setSpickku(Integer.valueOf(rows.get(29)));
            item.setHctenkanri(Integer.valueOf(rows.get(30)));
            item.setChangekaku(Integer.valueOf(rows.get(31)));
            item.setMaxzaik(Double.valueOf(rows.get(32)));
            item.setMinzaik(Double.valueOf(rows.get(33)));
            item.setStdcount(Integer.valueOf(rows.get(34)));
            item.setEmacount(Integer.valueOf(rows.get(35)));
            item.setZaikmin(Double.valueOf(rows.get(36)));
            item.setTempzaikmin(Double.valueOf(rows.get(37)));
            item.setMaxloth(Integer.valueOf(rows.get(38)));
            item.setMaxlots(Double.valueOf(rows.get(39)));
            item.setLotht(Integer.valueOf(rows.get(40)));
            item.setLotkikan(Double.valueOf(rows.get(41)));
            item.setFlatjyun(Integer.valueOf(rows.get(42)));
            item.setStzaikend(rows.get(43));
            item.setUchikiri(rows.get(44));
            item.setMatomeh(Integer.valueOf(rows.get(45)));
            item.setCalem(Integer.valueOf(rows.get(46)));
            item.setHikiku(Integer.valueOf(rows.get(47)));
            item.setHikilots(Double.valueOf(rows.get(48)));
            item.setMinasikubu(Integer.valueOf(rows.get(49)));
            item.setMinasigendo(Double.valueOf(rows.get(50)));
            item.setCompo(rows.get(51));
            item.setDolotbunkatu(Integer.valueOf(rows.get(52)));
            item.setPcapa(Double.valueOf(rows.get(53)));
            item.setTankah(Integer.valueOf(rows.get(54)));
            item.setSsumprice(Double.valueOf(rows.get(55)));
            item.setStumiprice(Double.valueOf(rows.get(56)));
            item.setPket(Integer.valueOf(rows.get(57)));
            item.setGakuj(Integer.valueOf(rows.get(58)));
            item.setKanzanz(Integer.valueOf(rows.get(59)));
            item.setKanzanp(Integer.valueOf(rows.get(60)));
            item.setKanzanza(Integer.valueOf(rows.get(61)));
            item.setKanzanj(Integer.valueOf(rows.get(62)));
            item.setKanzanv(Integer.valueOf(rows.get(63)));
            item.setKanzank(Double.valueOf(rows.get(64)));
            item.setTani2(rows.get(65));
            item.setDfaku(rows.get(66));
            item.setDfaku2(rows.get(67));
            item.setDfjku(rows.get(68));
            item.setDfjku2(rows.get(69));
            item.setKensa(Integer.valueOf(rows.get(70)));
            item.setKdesname(rows.get(71));
            item.setSlnohd(rows.get(72));
            item.setSetgrp(rows.get(73));
            item.setSetgrpratio(Double.valueOf(rows.get(74)));
            item.setKigenkubu(Integer.valueOf(rows.get(75)));
            item.setKigen(Integer.valueOf(rows.get(76)));
            item.setActlimit(Double.valueOf(rows.get(77)));
            item.setHikilimit(Double.valueOf(rows.get(78)));
            item.setNote(rows.get(79));
            item.setSysnote(rows.get(80));
            int insert = itemMapper.insert(item);
        }
        return null;
    }

    @Override
    public String exportExcel(Item searchItem) {
        QueryWrapper queryWrapper = new QueryWrapper(searchItem);
        List<Item> items = itemMapper.selectList(queryWrapper);
        HandleExcel handleExcel = new HandleExcel();
        HashMap<Integer, Object> firstCell = new HashMap<Integer, Object>();
        List<Map<Integer, Object>> contentCells = new ArrayList<Map<Integer, Object>>();
        String excelName = "items";
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
        firstCell.put(43, "目标仓");
        firstCell.put(44, "发料数量");
        firstCell.put(45, "计划发料日期");
        firstCell.put(46, "实绩数量");
        firstCell.put(47, "实绩发料日期");
        firstCell.put(48, "发料单号");
        firstCell.put(49, "物料编码");
        firstCell.put(50, "物料品番");
        firstCell.put(51, "来源仓");
        firstCell.put(52, "目标仓");
        firstCell.put(53, "发料数量");
        firstCell.put(54, "计划发料日期");
        firstCell.put(55, "实绩数量");
        firstCell.put(56, "实绩发料日期");
        firstCell.put(57, "发料单号");
        firstCell.put(58, "物料编码");
        firstCell.put(59, "物料品番");
        firstCell.put(60, "发料单号");
        firstCell.put(61, "物料编码");
        firstCell.put(62, "物料品番");
        firstCell.put(63, "来源仓");
        firstCell.put(64, "目标仓");
        firstCell.put(65, "发料数量");
        firstCell.put(66, "计划发料日期");
        firstCell.put(67, "实绩数量");
        firstCell.put(68, "实绩发料日期");
        firstCell.put(69, "发料单号");
        firstCell.put(70, "发料单号");
        firstCell.put(71, "物料编码");
        firstCell.put(72, "物料品番");
        firstCell.put(73, "来源仓");
        firstCell.put(74, "目标仓");
        firstCell.put(75, "发料数量");
        firstCell.put(76, "计划发料日期");
        firstCell.put(77, "实绩数量");
        firstCell.put(78, "实绩发料日期");
        firstCell.put(79, "发料单号");
        firstCell.put(80, "发料单号");
        if (items.size() > 0) {
            for (Item item : items){
                HashMap<Integer, Object> contentCell = new HashMap<Integer, Object>();
                contentCell.put(0, item.getCode());
                contentCell.put(1, item.getBunr());
                contentCell.put(2, item.getBumo());
                contentCell.put(3, item.getVendor());
                contentCell.put(4, item.getFixlevel());
                contentCell.put(5, item.getDkaku());
                contentCell.put(6, item.getKaku());
                contentCell.put(7, item.getKoteim());
                contentCell.put(8, item.getStzaik());
                contentCell.put(9, item.getLead());
                contentCell.put(10, item.getKouki());
                contentCell.put(11, item.getHojyuu());
                contentCell.put(12, item.getKuriage());
                contentCell.put(13, item.getJcode());
                contentCell.put(14, item.getKouthiki());
                contentCell.put(15, item.getHokan());
                contentCell.put(16, item.getNextbumo());
                contentCell.put(17, item.getLoth());
                contentCell.put(18, item.getLots());
                contentCell.put(19, item.getLots2());
                contentCell.put(20, item.getHimoku());
                contentCell.put(21, item.getFuryou());
                contentCell.put(22, item.getLead2());
                contentCell.put(23, item.getTanikouki());
                contentCell.put(24, item.getKouki2());
                contentCell.put(25, item.getLinkslip());
                contentCell.put(26, item.getNokanri());
                contentCell.put(27, item.getPickku());
                contentCell.put(28, item.getPicklots());
                contentCell.put(29, item.getSpickku());
                contentCell.put(30, item.getHctenkanri());
                contentCell.put(31, item.getChangekaku());
                contentCell.put(32, item.getMaxzaik());
                contentCell.put(33, item.getMinzaik());
                contentCell.put(34, item.getStdcount());
                contentCell.put(35, item.getEmacount());
                contentCell.put(36, item.getZaikmin());
                contentCell.put(37, item.getTempzaikmin());
                contentCell.put(38, item.getMaxloth());
                contentCell.put(39, item.getMaxloth());
                contentCell.put(40, item.getLotht());
                contentCell.put(41, item.getLotkikan());
                contentCell.put(42, item.getFlatjyun());
                contentCell.put(43, item.getStzaikend());
                contentCell.put(44, item.getUchikiri());
                contentCell.put(45, item.getMatomeh());
                contentCell.put(46, item.getCalem());
                contentCell.put(47, item.getHikiku());
                contentCell.put(48, item.getHikilots());
                contentCell.put(49, item.getMinasikubu());
                contentCell.put(50, item.getMinasigendo());
                contentCell.put(51, item.getCompo());
                contentCell.put(52, item.getDolotbunkatu());
                contentCell.put(53, item.getPcapa());
                contentCell.put(54, item.getTankah());
                contentCell.put(55, item.getSsumprice());
                contentCell.put(56, item.getStumiprice());
                contentCell.put(57, item.getPket());
                contentCell.put(58, item.getGakuj());
                contentCell.put(59, item.getKanzanz());
                contentCell.put(60, item.getKanzanp());
                contentCell.put(61, item.getKanzanza());
                contentCell.put(62, item.getKanzanj());
                contentCell.put(63, item.getKanzanv());
                contentCell.put(64, item.getKanzank());
                contentCell.put(65, item.getTani2());
                contentCell.put(66, item.getDfaku());
                contentCell.put(67, item.getDfaku2());
                contentCell.put(68, item.getDfjku());
                contentCell.put(69, item.getDfjku2());
                contentCell.put(70, item.getKensa());
                contentCell.put(71, item.getKdesname());
                contentCell.put(72, item.getSlnohd());
                contentCell.put(73, item.getSetgrp());
                contentCell.put(74, item.getSetgrpratio());
                contentCell.put(75, item.getKigenkubu());
                contentCell.put(76, item.getKigen());
                contentCell.put(77, item.getActlimit());
                contentCell.put(78, item.getHikilimit());
                contentCell.put(79, item.getNote());
                contentCell.put(80, item.getSysnote());
                contentCells.add(contentCell);
            }
        }
        String filePath = HandleExcel.EXPORT_EXCEL_LOCATION;

        String result = handleExcel.exportExcel(firstCell, contentCells, excelName, filePath);
        return result;
    }

}
