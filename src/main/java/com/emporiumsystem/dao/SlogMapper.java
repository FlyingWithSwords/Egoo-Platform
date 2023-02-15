package com.emporiumsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emporiumsystem.model.Slog;
import com.emporiumsystem.model.Stat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: FlyingWithSwords
 * @CreateTime: 2023-01-15  09:35
 * @Description: TODO
 * @Version: 1.0
 */
@Component("slogDao")
public interface SlogMapper extends BaseMapper<Slog> {

    List<Slog> querySlogAll(Slog slog);

    //统计处理
    List<Stat> queryStat(@Param("type") String type, @Param("where") String where);

}
