package com.emporiumsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emporiumsystem.model.Address;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAddressService extends IService<Address> {

    PageInfo<Address> findAddressAll(int page, int pageSize, Address address);

    List<Address> findAll(Address address);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Address>
     */
    IPage<Address> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param Address
     * @return int
     */
    int add(Address address);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param Address
     * @return int
     */
    int updateData(Address address);

    /**
     * id查询数据
     *
     * @param id id
     * @return Address
     */
    Address findById(Long id);
}
