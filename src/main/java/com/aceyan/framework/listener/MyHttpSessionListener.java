package com.aceyan.framework.listener;

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
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.err.println("session 创建 ");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.err.println("session 销毁 ");
    }
}
