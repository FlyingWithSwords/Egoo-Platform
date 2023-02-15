package com.emporiumsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emporiumsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: FlyingWithSwords
 * @CreateTime: 2023-01-15  09:35
 * @Description: TODO
 * @Version: 1.0
 */
@Component("userDao")
public interface UserMapper extends BaseMapper<User> {

    List<User> queryUserAll(User user);

    User queryUserByNameAndPwd(User user);

}
