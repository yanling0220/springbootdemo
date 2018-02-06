package com.boot.dao;

import com.boot.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户接口
 *
 * @author yanling
 * @time 2018-01-11-18:41
 */
public interface IUserDao extends CrudRepository<User,Long> {

}
