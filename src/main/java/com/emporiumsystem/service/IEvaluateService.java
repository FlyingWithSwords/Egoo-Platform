package com.emporiumsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emporiumsystem.model.Evaluate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IEvaluateService extends IService<Evaluate> {

    PageInfo<Evaluate> findEvaluateAll(int page, int pageSize, Evaluate evaluate);

    List<Evaluate> findAll(Evaluate evaluate);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Evaluate>
     */
    IPage<Evaluate> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param Evaluate
     * @return int
     */
    int add(Evaluate Evaluate);

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
     * @param Evaluate
     * @return int
     */
    int updateData(Evaluate evaluate);

    /**
     * id查询数据
     *
     * @param id id
     * @return Evaluate
     */
    Evaluate findById(Long id);
}
