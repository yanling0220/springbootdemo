package com.boot.mapper;

import com.boot.entity.User;
import com.boot.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where name = #{name}")
    public User findByUsername(String username);

    @Select("select * from user")
    public List<User> findAll();
}
