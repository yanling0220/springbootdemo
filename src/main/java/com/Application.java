package com;

import com.aceyan.framework.config.PropertiesConfigurer;
import com.aceyan.framework.properties.Wisely2Settings;
import com.aceyan.framework.properties.WiselySettings;
import com.aceyan.framework.servlet.MyServlet;
import com.aceyan.framework.util.SpringUtil2;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




/**
 * restful web
 *
 * @author yanling
 * @time 2017-09-07-14:54
 */
@ControllerAdvice
@ServletComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application extends WebMvcConfigurerAdapter {


    /*@Bean
    public SpringUtil2 springUtil2() {
        return new SpringUtil2();
    }*/
    /*@Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/myServlet/*");
    }*/

    public static void main(String[] args) {
        Object[] objects = new Object[]{
                Application.class,
                //GlobalDefaultExceptionHandler.class,
                //AppConfigurer.class,
                //SchedulingConfig.class,
                //UserService.class
        };
        SpringApplication.run(objects,args);
        /*SpringApplication application = new SpringApplication(Application.class);
        *//*设置spring-boot banner 不显示*//*
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);*/
    }


    /**
     *messageConverters 返回数据格式, 实现2中方式
     * 1、继承 org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter 重写 configureMessageConverters 方法
     * 2、Bean配置
     * @return
     */
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }*/

 /*   @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }*/

}
