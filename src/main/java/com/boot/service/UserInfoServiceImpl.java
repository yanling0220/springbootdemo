package com.boot.service;

import com.alibaba.fastjson.JSON;
import com.boot.dao.IUserInfoDao;
import com.boot.entity.User;
import com.boot.entity.UserInfo;
import com.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanling
 * @time 2018-02-06-16:05
 */
@Component
public class UserInfoServiceImpl  {
    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private UserMapper userMapper;
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        User userInfo  = userMapper.findByUsername(username);
        System.err.println(JSON.toJSONString(userInfo));
        return userInfoDao.findByUsername(username);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

}
