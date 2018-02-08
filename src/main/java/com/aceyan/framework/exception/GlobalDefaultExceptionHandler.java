package com.aceyan.framework.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 *
 * @author yanling
 * @time 2018-01-10-16:30
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest req, Exception e){
        System.err.println(req.getParameter("name"));
        System.err.println("GlobalDefaultExceptionHandler.defaultErrorHandler() e = "+ e.toString());
        return "系统异常！！";
    }
}
