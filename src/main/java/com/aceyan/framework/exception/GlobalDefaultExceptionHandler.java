package com.aceyan.framework.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 *
 * @author yanling
 * @time 2018-01-10-16:30
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public void defaultErrorHandler(HttpServletRequest req, Exception e){
        System.err.println(req.getParameter("name"));
        System.err.println("GlobalDefaultExceptionHandler.defaultErrorHandler() e = "+ e.getMessage());
    }
}
