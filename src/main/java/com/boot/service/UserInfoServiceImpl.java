package com.boot.service;

import com.boot.dao.IUserInfoDao;
import com.boot.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yanling
 * @time 2018-02-06-16:05
 */
@Component
public class UserInfoServiceImpl  {
    @Autowired
    private IUserInfoDao userInfoDao;
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
