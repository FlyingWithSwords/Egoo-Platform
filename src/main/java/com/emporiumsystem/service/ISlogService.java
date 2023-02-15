package com.emporiumsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emporiumsystem.model.Slog;
import com.emporiumsystem.model.Stat;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISlogService extends IService<Slog> {

    PageInfo<Slog> findSlogAll(int page, int pageSize, Slog slog);

    List<Slog> findAll(Slog Slog);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Slog>
     */
    IPage<Slog> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param Slog
     * @return int
     */
    int add(Slog slog);

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
     * @param Slog
     * @return int
     */
    int updateData(Slog slog);

    /**
     * id查询数据
     *
     * @param id id
     * @return Slog
     */
    Slog findById(Long id);

    List<Stat> queryStat(String type, String where);
}
