package com.aceyan.framework.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听
 *
 * @author yanling
 * @time 2018-01-24-14:42
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("监听器 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("监听器 销毁");
    }
}
