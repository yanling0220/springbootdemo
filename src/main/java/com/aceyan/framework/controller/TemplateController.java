package com.aceyan.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author yanling
 * @time 2018-01-23-16:45
 */
@Controller
public class TemplateController {
    /**
     *返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello1","fromTemplateController.helloHtml1");
        map.put("hello","你好！ 测试内容");
        return"/helloHtml";
    }
}
