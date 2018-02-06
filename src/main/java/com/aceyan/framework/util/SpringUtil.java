package com.aceyan.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 *普通类调用Spring bean对象：
 *说明：
 * 1、此类需要放到App.java同包或者子包下才能被扫描，否则失效。
 * @author yanling
 * @time 2018-01-23-13:52
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
        System.err.println("---------------------------------------------------------------------");
        System.err.println("---------------------------------------------------------------------");
        System.err.println("---------------com.aceyan.framework.util.SpringUtil------------------------------------------------------");
        System.err.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil.applicationContext+"========");
        System.err.println("---------------------------------------------------------------------");
    }

    /**
     * 获取applicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }
}
