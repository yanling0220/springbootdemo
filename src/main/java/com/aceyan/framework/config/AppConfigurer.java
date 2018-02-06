package com.aceyan.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 处理静态资源
 *
 * @author yanling
 * @time 2018-01-10-18:18
 */
//@ImportResource(locations = {"classpath:application-bean.xml"})
//@Configuration
public class AppConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 测试路径没有生效， 应该此处配置是不对restapi接口生效
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        super.addResourceHandlers(registry);
    }
}
