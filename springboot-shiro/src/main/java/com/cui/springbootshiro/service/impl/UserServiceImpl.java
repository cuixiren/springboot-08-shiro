package com.cui.springbootshiro.service.impl;

import com.cui.springbootshiro.entity.User;
import com.cui.springbootshiro.mapper.UserMapper;
import com.cui.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @FileName: UserServiceImpl
 * @Author: cuixr
 * @Date: 2022/1/28 16:24
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
