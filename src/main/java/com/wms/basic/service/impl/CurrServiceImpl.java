package com.wms.basic.service.impl;

import com.wms.basic.entity.Curr;
import com.wms.basic.mapper.CurrMapper;
import com.wms.basic.service.ICurrService;
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
public class CurrServiceImpl extends ServiceImpl<CurrMapper, Curr> implements ICurrService {

    @Autowired
    private CurrMapper currMapper;

    @Override
    public List<Curr> getCurrList(Curr curr){
        List<Curr> currs = null;
        currs  = currMapper.getCurrList(curr);
        return currs;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Curr getCurrById(Curr curr){
        curr = currMapper.getCurrById(curr);
        return curr;
    }

    @Override
    public void updateCurr(Curr curr){
        currMapper.updateById(curr);
    }

    @Override
    public void insertCurr(Curr curr){
        currMapper.insert(curr);
    }

    @Override
    public void deleteCurr(Curr curr){
        currMapper.deleteById(curr);
    }

    @Override
    public void deleteCurrList(List<Curr> currs) {
        currMapper.deleteBatchIds(currs);
    }
}
