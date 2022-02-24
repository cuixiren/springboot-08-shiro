package com.cui.springbootshiro.service;

import com.cui.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @FileName: UserService
 * @Author: cuixr
 * @Date: 2022/1/28 16:24
 * @Description:
 */
public interface UserService {
    public User queryUserByName(String name);
}
