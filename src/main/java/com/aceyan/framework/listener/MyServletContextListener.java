package com.aceyan.framework.listener;

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

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.err.println("监听器 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.err.println("监听器 销毁");
    }
}
