package com.boot.test;

import com.Application;
import com.alibaba.fastjson.JSON;
import com.boot.entity.User;
import com.boot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 测试类
 *
 * @author yanling
 * @time 2018-01-29-9:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class HelloApplicationTest {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        assertEquals("hello",userService.hello());
    }
    @Test
    public void test1(){
        List<User> users = userService.queryAllUser();
        System.err.println(JSON.toJSONString(users));
        assertNotNull(users);
    }


}
