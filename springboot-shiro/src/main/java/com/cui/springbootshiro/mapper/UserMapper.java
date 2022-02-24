package com.cui.springbootshiro.mapper;

import com.cui.springbootshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @FileName: UserMapper
 * @Author: cuixr
 * @Date: 2022/1/28 16:19
 * @Description:
 */
@Mapper
public interface UserMapper {
    @Select("select * FROM user where name=#{name}")
    public User queryUserByName(@Param("name")String name);
}
