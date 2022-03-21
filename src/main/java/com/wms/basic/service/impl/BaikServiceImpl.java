package com.wms.basic.service.impl;

import com.wms.basic.entity.Baik;
import com.wms.basic.mapper.BaikMapper;
import com.wms.basic.service.IBaikService;
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
public class BaikServiceImpl extends ServiceImpl<BaikMapper, Baik> implements IBaikService {

    @Autowired
    private BaikMapper baikMapper;

    @Override
    public List<Baik> getBaikList(Baik baik){
        List<Baik> baiks = null;
        baiks  = baikMapper.getBaikList(baik);
        return baiks;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Baik getBaikById(Baik baik){
        baik = baikMapper.getBaikById(baik);
        return baik;
    }

    @Override
    public void updateBaik(Baik baik){
        baikMapper.updateById(baik);
    }

    @Override
    public void insertBaik(Baik baik){
        baikMapper.insert(baik);
    }

    @Override
    public void deleteBaik(Baik baik){
        baikMapper.deleteById(baik);
    }

    @Override
    public void deleteBaikList(List<Baik> baiks) {
        baikMapper.deleteBatchIds(baiks);
    }
}
