package com.emporiumsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emporiumsystem.model.Commodity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICommodityService extends IService<Commodity> {

    PageInfo<Commodity> findCommodityAll(int page, int pageSize, Commodity commodity);

    List<Commodity> findAll(Commodity commodity);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Commodity>
     */
    IPage<Commodity> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param Commodity
     * @return int
     */
    int add(Commodity commodity);

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
     * @param Commodity
     * @return int
     */
    int updateData(Commodity commodity);

    /**
     * id查询数据
     *
     * @param id id
     * @return Commodity
     */
    Commodity findById(Long id);
}
