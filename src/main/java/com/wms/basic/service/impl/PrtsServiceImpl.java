package com.wms.basic.service.impl;

import com.wms.basic.entity.Prts;
import com.wms.basic.mapper.PrtsMapper;
import com.wms.basic.service.IPrtsService;
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
 * @since 2022-03-20
 */
@Service
public class PrtsServiceImpl extends ServiceImpl<PrtsMapper, Prts> implements IPrtsService {

    @Autowired
    private PrtsMapper prtsMapper;

    @Override
    public List<Prts> getPrtsList(Prts prts){
        List<Prts> prtss = null;
        prtss  = prtsMapper.getPrtsList(prts);
        return prtss;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Prts getPrtsById(Prts prts){
        prts = prtsMapper.getPrtsById(prts);
        return prts;
    }

    @Override
    public void updatePrts(Prts prts){
        prtsMapper.updateById(prts);
    }

    @Override
    public void insertPrts(Prts prts){
        prtsMapper.insert(prts);
    }

    @Override
    public void deletePrts(Prts prts){
        prtsMapper.deleteById(prts);
    }

    @Override
    public void deletePrtsList(List<Prts> prtss) {
        prtsMapper.deleteBatchIds(prtss);
    }
}
