package com.aceyan.framework.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author yanling
 * @time 2018-01-24-16:44
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyEnvironmentAware.class);
    @Value("${application.hello}")
    private String text;

    @Override
    public void setEnvironment(Environment environment) {
        LOGGER.info("text : " + text);
        LOGGER.info("Java Home : " + environment.getProperty("JAVA_HOME"));

        //通过 environment同样能获取到application.properties配置的属性.
        System.out.println(environment.getProperty("spring.datasource.url"));
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource.");
        System.out.println("spring.datasource.url="+relaxedPropertyResolver.getProperty("url"));
        System.out.println("spring.datasource.driverClassName=" + relaxedPropertyResolver.getProperty("driver-class-name"));
    }


}
