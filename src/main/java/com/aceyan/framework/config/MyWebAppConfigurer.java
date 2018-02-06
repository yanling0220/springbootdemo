package com.aceyan.framework.config;

import com.aceyan.framework.interceptor.MyInterceptor;
import com.aceyan.framework.interceptor.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Intercept config
 *
 * @author yanling
 * @time 2018-01-24-15:18
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
