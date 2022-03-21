package com.wms.basic.service.impl;

import com.wms.basic.entity.Sect;
import com.wms.basic.mapper.SectMapper;
import com.wms.basic.service.ISectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wjc
 * @since 2022-03-21
 */
@Service
public class SectServiceImpl extends ServiceImpl<SectMapper, Sect> implements ISectService {

    @Autowired
    private SectMapper sectMapper;

    @Override
    public List<Sect> getSectList(Sect sect){
        List<Sect> sects = null;
        sects  = sectMapper.getSectList(sect);
        return sects;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Sect getSectById(Sect sect){
        sect = sectMapper.getSectById(sect);
        return sect;
    }

    @Override
    public void updateSect(Sect sect){
        sectMapper.updateById(sect);
    }

    @Override
    public void insertSect(Sect sect){
        sectMapper.insert(sect);
    }

    @Override
    public void deleteSect(Sect sect){
        sectMapper.deleteById(sect);
    }

    @Override
    public void deleteSectList(List<Sect> sects) {
        sectMapper.deleteBatchIds(sects);
    }
}
