package com.emporiumsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emporiumsystem.model.Cart;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICartService extends IService<Cart> {

    PageInfo<Cart> findCartAll(int page, int pageSize, Cart cart);

    List<Cart> findAll(Cart cart);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Cart>
     */
    IPage<Cart> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param Cart
     * @return int
     */
    int add(Cart cart);

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
     * @param Cart
     * @return int
     */
    int updateData(Cart cart);

    /**
     * id查询数据
     *
     * @param id id
     * @return Cart
     */
    Cart findById(Long id);
}
