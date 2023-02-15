package com.emporiumsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emporiumsystem.dao.AddressMapper;
import com.emporiumsystem.model.Address;
import com.emporiumsystem.service.IAddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Autowired
    private AddressMapper addressDao;
    @Override
    public PageInfo<Address> findAddressAll(int page, int pageSize, Address address) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<Address> list=addressDao.queryAddressAll(address);
        PageInfo<Address> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Address> findAll(Address address) {
        List<Address> list=addressDao.queryAddressAll(address);
        return list;
    }

    @Override
    public IPage<Address> findListByPage(Integer page, Integer pageCount){
        IPage<Address> wherePage = new Page<>(page, pageCount);
        Address where = new Address();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Address address){
        return baseMapper.insert(address);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Address address){
        return baseMapper.updateById(address);
    }

    @Override
    public Address findById(Long id){
        return baseMapper.selectById(id);
    }
}
