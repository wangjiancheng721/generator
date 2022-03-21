package com.wms.basic.service.impl;

import com.wms.basic.entity.Tank;
import com.wms.basic.mapper.TankMapper;
import com.wms.basic.service.ITankService;
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
public class TankServiceImpl extends ServiceImpl<TankMapper, Tank> implements ITankService {

    @Autowired
    private TankMapper tankMapper;

    @Override
    public List<Tank> getTankList(Tank tank){
        List<Tank> tanks = null;
        tanks  = tankMapper.getTankList(tank);
        return tanks;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Tank getTankById(Tank tank){
        tank = tankMapper.getTankById(tank);
        return tank;
    }

    @Override
    public void updateTank(Tank tank){
        tankMapper.updateById(tank);
    }

    @Override
    public void insertTank(Tank tank){
        tankMapper.insert(tank);
    }

    @Override
    public void deleteTank(Tank tank){
        tankMapper.deleteById(tank);
    }

    @Override
    public void deleteTankList(List<Tank> tanks) {
        tankMapper.deleteBatchIds(tanks);
    }
}
