package com.wms.basic.service.impl;

import com.wms.basic.entity.Head;
import com.wms.basic.mapper.HeadMapper;
import com.wms.basic.service.IHeadService;
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
public class HeadServiceImpl extends ServiceImpl<HeadMapper, Head> implements IHeadService {

    @Autowired
    private HeadMapper headMapper;

    @Override
    public List<Head> getHeadList(Head head){
        List<Head> heads = null;
        heads  = headMapper.getHeadList(head);
        return heads;

    }

    /**
    * 注意当前的id主键 是默认的"id"，具体情况根据数据库主键的名称进行修改
    */
    @Override
    public Head getHeadById(Head head){
        head = headMapper.getHeadById(head);
        return head;
    }

    @Override
    public void updateHead(Head head){
        headMapper.updateById(head);
    }

    @Override
    public void insertHead(Head head){
        headMapper.insert(head);
    }

    @Override
    public void deleteHead(Head head){
        headMapper.deleteById(head);
    }

    @Override
    public void deleteHeadList(List<Head> heads) {
        headMapper.deleteBatchIds(heads);
    }
}
