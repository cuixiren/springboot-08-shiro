package com.cui.springbootshiro.entity;

import lombok.Data;

/**
 * @FileName: User
 * @Author: cuixr
 * @Date: 2022/1/28 16:17
 * @Description:
 */
@Data
public class User {
    private int id;
    private String name;
    private String pwd;
    private String perms;
}
