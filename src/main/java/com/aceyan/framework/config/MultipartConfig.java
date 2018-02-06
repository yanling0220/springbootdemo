package com.aceyan.framework.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传处理配置文件
 *
 * @author yanling
 * @time 2018-01-29-17:54
 */
@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("256KB");
        factory.setLocation("D:/yanlingTestFile");
        return factory.createMultipartConfig();
    }
}
