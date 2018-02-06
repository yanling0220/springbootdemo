package com.aceyan.framework.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
