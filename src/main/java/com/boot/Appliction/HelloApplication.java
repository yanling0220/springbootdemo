package com.boot.Appliction;

import com.aceyan.framework.properties.Wisely2Settings;
import com.aceyan.framework.properties.WiselySettings;
import com.alibaba.fastjson.JSON;
import com.boot.entity.Greeting;
import com.boot.entity.User;
import com.boot.entity.UserInfo;
import com.boot.service.UserInfoServiceImpl;
import com.boot.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/ling/yan")
public class HelloApplication {

    @Resource
    private UserService userService;

    @Resource
    private UserInfoServiceImpl userInfoService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
        System.err.println("asdfasdf54asdfas 111111");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        /*User user = new User();
        user.setAddress("湖南长沙");
        user.setAge(25L);
        user.setName("YL");*/
        userService.save(user);
        return "SUCCESS";
    }

    @RequestMapping("/queryAllUser")
    public List<User> queryAllUser(){
       List<User> users =  userService.queryAllUser();
        return users;
    }

    @Autowired
    private WiselySettings wiselySettings;
    @Autowired
    private Wisely2Settings wisely2Settings;

    @RequestMapping("/test")
    public String test(){
        System.err.println(wiselySettings.getGender()+"---"+wiselySettings.getName());
        wiselySettings.setGender("famale");
        wiselySettings.setName("Lucy");
        System.err.println(wiselySettings.getGender()+"==="+wiselySettings.getName());
        System.err.println(wisely2Settings.getGender()+"---"+wisely2Settings.getName());

        System.err.println(wisely2Settings.getGender()+"---"+wisely2Settings.getName());
        return "SUCCESS";
    }
    @RequestMapping(value = "/findByUsername",method = RequestMethod.GET)
    @RequiresPermissions("userInfo:view")
    public UserInfo findByUsername(String username,String password){
        System.err.println(MessageFormat.format("userName = {0} , passWord = {1}",username,password));
        UserInfo users = userInfoService.findByUsername(username);
        System.err.println(JSON.toJSONString(users));
        return users;
    }

}
