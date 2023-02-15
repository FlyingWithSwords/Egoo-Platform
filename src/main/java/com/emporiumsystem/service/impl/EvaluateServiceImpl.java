package com.emporiumsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emporiumsystem.dao.EvaluateMapper;
import com.emporiumsystem.model.Evaluate;
import com.emporiumsystem.service.IEvaluateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements IEvaluateService {

    @Autowired
    private EvaluateMapper evaluateDao;
    @Override
    public PageInfo<Evaluate> findEvaluateAll(int page, int pageSize, Evaluate evaluate) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<Evaluate> list=evaluateDao.queryEvaluateAll(evaluate);
        PageInfo<Evaluate> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Evaluate> findAll(Evaluate evaluate) {
        List<Evaluate> list=evaluateDao.queryEvaluateAll(evaluate);
        return list;
    }

    @Override
    public IPage<Evaluate> findListByPage(Integer page, Integer pageCount){
        IPage<Evaluate> wherePage = new Page<>(page, pageCount);
        Evaluate where = new Evaluate();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Evaluate evaluate){
        return baseMapper.insert(evaluate);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Evaluate evaluate){
        return baseMapper.updateById(evaluate);
    }

    @Override
    public Evaluate findById(Long id){
        return baseMapper.selectById(id);
    }
}
