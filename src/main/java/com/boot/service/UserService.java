package com.boot.service;

import com.boot.dao.IUserDao;
import com.boot.entity.User;
import com.google.common.collect.Lists;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务接口
 *
 * @author yanling
 * @time 2018-01-11-18:43
 */
@Component
public class UserService{
    @Resource
    private IUserDao userDao;
    @Transactional
    public void save(User user){
         userDao.save(user);
    }
    @Cacheable(value = "queryAllUser")
    public List<User> queryAllUser(){
        Iterable<User> users = userDao.findAll();
        List<User> user = Lists.newArrayList(users);
        return user;
    }

    public String hello(){
        return "hello";
    }

}
