package com.aceyan.framework.config;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis 分页工具 配置
 *
 * @author yanling
 * @time 2018-03-01-11:41
 */
@Configuration
public class MybatisConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisConfiguration.class);
    @Bean
    public PageHelper pageHelper(){
        LOGGER.info("com.aceyan.framework.config.MybatisConfiguration.pageHelper  分页 工具运用");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
