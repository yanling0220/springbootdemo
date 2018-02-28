package com.aceyan.framework.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest req, Exception e){
        LOGGER.info(req.getParameter("name"));
        LOGGER.info("GlobalDefaultExceptionHandler.defaultErrorHandler() e = "+ e.toString());
        return "系统异常！！";
    }
}
