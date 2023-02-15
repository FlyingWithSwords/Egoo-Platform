package com.emporiumsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emporiumsystem.dao.CartMapper;
import com.emporiumsystem.model.Cart;
import com.emporiumsystem.service.ICartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Autowired
    private CartMapper cartDao;
    @Override
    public PageInfo<Cart> findCartAll(int page, int pageSize, Cart cart) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<Cart> list=cartDao.queryCartAll(cart);
        PageInfo<Cart> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Cart> findAll(Cart cart) {
        List<Cart> list=cartDao.queryCartAll(cart);
        return list;
    }

    @Override
    public IPage<Cart> findListByPage(Integer page, Integer pageCount){
        IPage<Cart> wherePage = new Page<>(page, pageCount);
        Cart where = new Cart();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Cart cart){
        return baseMapper.insert(cart);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Cart cart){
        return baseMapper.updateById(cart);
    }

    @Override
    public Cart findById(Long id){
        return baseMapper.selectById(id);
    }
}
