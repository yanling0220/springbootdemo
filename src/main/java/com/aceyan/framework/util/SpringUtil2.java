package com.aceyan.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author yanling
 * @time 2018-01-23-14:44
 */
public class SpringUtil2 implements ApplicationContextAware{
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringUtil2.class);
    private static ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil2.applicationContext == null){
            SpringUtil2.applicationContext = applicationContext;
        }
        LOGGER.info("---------------------------------------------------------------------");
        LOGGER.info("---------------------------------------------------------------------");
        LOGGER.info("---------------com.aceyan.framework.util.SpringUtil2------------------------------------------------------");
        LOGGER.info("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil2.applicationContext+"========");
        LOGGER.info("---------------------------------------------------------------------");
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
