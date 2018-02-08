package com.boot.dao;

import com.boot.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户信息
 */
public interface IUserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
        public UserInfo findByUsername(String username);
}
