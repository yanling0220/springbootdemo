package com.aceyan.framework.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author yanling
 * @time 2018-01-23-17:10
 */
@Controller
public class HelloController {
    @Value("${application.hello}")
    private String hello;
    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello",hello);
        map.put("date",new Date());
        System.err.println("HelloController.helloJsp().hello="+hello);
        return"/helloJsp";
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login(HttpServletRequest request,Map<String,Object> map){
        System.err.println("Login");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }


}
