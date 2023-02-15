package com.emporiumsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emporiumsystem.dao.SlogMapper;
import com.emporiumsystem.model.Slog;
import com.emporiumsystem.model.Stat;
import com.emporiumsystem.service.ISlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlogServiceImpl extends ServiceImpl<SlogMapper, Slog> implements ISlogService {

    @Autowired
    private SlogMapper slogDao;
    @Override
    public PageInfo<Slog> findSlogAll(int page, int pageSize, Slog slog) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<Slog> list=slogDao.querySlogAll(slog);
        PageInfo<Slog> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Slog> findAll(Slog slog) {
        List<Slog> list=slogDao.querySlogAll(slog);
        return list;
    }

    @Override
    public IPage<Slog> findListByPage(Integer page, Integer pageCount){
        IPage<Slog> wherePage = new Page<>(page, pageCount);
        Slog where = new Slog();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Slog Slog){
        return baseMapper.insert(Slog);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Slog slog){
        return baseMapper.updateById(slog);
    }

    @Override
    public Slog findById(Long id){
        return baseMapper.selectById(id);
    }
    
    @Override
    public List<Stat> queryStat(String type, String where) {
        return slogDao.queryStat(type, where);
    }
}
