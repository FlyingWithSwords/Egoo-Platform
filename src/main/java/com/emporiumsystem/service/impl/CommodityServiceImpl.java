package com.emporiumsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emporiumsystem.dao.CommodityMapper;
import com.emporiumsystem.model.Commodity;
import com.emporiumsystem.service.ICommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Autowired
    private CommodityMapper commodityDao;
    @Override
    public PageInfo<Commodity> findCommodityAll(int page, int pageSize, Commodity Commodity) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<Commodity> list=commodityDao.queryCommodityAll(Commodity);
        PageInfo<Commodity> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Commodity> findAll(Commodity commodity) {
        List<Commodity> list=commodityDao.queryCommodityAll(commodity);
        return list;
    }

    @Override
    public IPage<Commodity> findListByPage(Integer page, Integer pageCount){
        IPage<Commodity> wherePage = new Page<>(page, pageCount);
        Commodity where = new Commodity();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Commodity commodity){
        return baseMapper.insert(commodity);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Commodity commodity){
        return baseMapper.updateById(commodity);
    }

    @Override
    public Commodity findById(Long id){
        return baseMapper.selectById(id);
    }
}
