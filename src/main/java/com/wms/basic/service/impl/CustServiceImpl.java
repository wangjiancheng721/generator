package com.wms.basic.service.impl;

import com.wms.basic.entity.Cust;
import com.wms.basic.mapper.CustMapper;
import com.wms.basic.service.ICustService;
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
public class CustServiceImpl extends ServiceImpl<CustMapper, Cust> implements ICustService {

    @Autowired
    private CustMapper custMapper;

    @Override
    public List<Cust> getCustList(Cust cust){
        List<Cust> custs = null;
        custs  = custMapper.getCustList(cust);
        return custs;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Cust getCustById(Cust cust){
        cust = custMapper.getCustById(cust);
        return cust;
    }

    @Override
    public void updateCust(Cust cust){
        custMapper.updateById(cust);
    }

    @Override
    public void insertCust(Cust cust){
        custMapper.insert(cust);
    }

    @Override
    public void deleteCust(Cust cust){
        custMapper.deleteById(cust);
    }

    @Override
    public void deleteCustList(List<Cust> custs) {
        custMapper.deleteBatchIds(custs);
    }
}
