package com.aceyan.framework.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器 Session
 *
 * @author yanling
 * @time 2018-01-24-14:50
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHttpSessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("session 创建 ");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("session 销毁 ");
    }
}
