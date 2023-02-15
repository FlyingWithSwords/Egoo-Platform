package com.emporiumsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emporiumsystem.model.Commodity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: FlyingWithSwords
 * @CreateTime: 2023-01-15  09:35
 * @Description: TODO
 * @Version: 1.0
 */
@Component("commodityDao")
public interface CommodityMapper extends BaseMapper<Commodity> {

    List<Commodity> queryCommodityAll(Commodity commodity);

}
