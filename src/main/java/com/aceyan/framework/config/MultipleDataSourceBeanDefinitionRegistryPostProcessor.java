package com.aceyan.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 动态多数据源注入
 *
 * @author yanling
 * @time 2018-02-09-14:27
 */
@Configuration
public class MultipleDataSourceBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor,EnvironmentAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(MultipleDataSourceBeanDefinitionRegistryPostProcessor.class);
    /**
     * 作用域对象
     */
    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
    /**
     * Bean 名称生成器
     */
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
    /**
     * 指定数据类型
     */
    private final Object DATASOURCE_TYPE_DEFAULT ="com.alibaba.druid.pool.DruidDataSource";
    /**
     * DataSource配置集合
     */
    private Map<String, Map<String, Object>> dataSourceMap = new HashMap<>();

    private final String DRIVER_CLASS_NAME = "driverClassName";
    private final String URL = "url";
    private final String USER_NAME = "username";
    private final String PASS_WORD = "password";
    private final String TYPE = "type";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        LOGGER.info("com.aceyan.framework.config.MultipleDataSourceBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
        try {
            if (!dataSourceMap.isEmpty()){
                for(Entry<String,Map<String,Object>>entry:dataSourceMap.entrySet()){
                    /*获取数据源类型*/
                    Object type = entry.getValue().get(TYPE);
                    if (type == null){
                        type = DATASOURCE_TYPE_DEFAULT;
                    }
                    registryBean(beanDefinitionRegistry,entry.getKey(),Class.forName(type.toString()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        LOGGER.info("com.aceyan.framework.config.MultipleDataSourceBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
        /**
         * 设置为主数据源
         */
        configurableListableBeanFactory.getBeanDefinition("druidDataSource").setPrimary(true);
        if (!dataSourceMap.isEmpty()){
            BeanDefinition beanDefinition = null;
            Map<String, Object> dsMap  = null;
            MutablePropertyValues mutablePropertyValues = null;

            for (Entry<String, Map<String,Object>> entry : dataSourceMap.entrySet()){
                beanDefinition = configurableListableBeanFactory.getBeanDefinition(entry.getKey());
                mutablePropertyValues = beanDefinition.getPropertyValues();
                dsMap = entry.getValue();
                mutablePropertyValues.addPropertyValue(DRIVER_CLASS_NAME,dsMap.get(DRIVER_CLASS_NAME));
                mutablePropertyValues.addPropertyValue(URL, dsMap.get(URL));
                mutablePropertyValues.addPropertyValue(USER_NAME, dsMap.get(USER_NAME));
                mutablePropertyValues.addPropertyValue(PASS_WORD,dsMap.get(PASS_WORD));
            }
        }

    }

    private void registryBean(BeanDefinitionRegistry registry , String name , Class<?> beanClass){
        AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
        ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(annotatedGenericBeanDefinition);
        annotatedGenericBeanDefinition.setScope(scopeMetadata.getScopeName());
        String beanName = StringUtils.isEmpty(name) ? this.beanNameGenerator.generateBeanName(annotatedGenericBeanDefinition, registry) : name;
        AnnotationConfigUtils.processCommonDefinitionAnnotations(annotatedGenericBeanDefinition);

        BeanDefinitionHolder holder = new BeanDefinitionHolder(annotatedGenericBeanDefinition,beanName);
        BeanDefinitionReaderUtils.registerBeanDefinition(holder,registry);
    }

    @Override
    public void setEnvironment(Environment environment) {
        LOGGER.info("com.aceyan.framework.config.MultipleDataSourceBeanDefinitionRegistryPostProcessor.setEnvironment");
        //获取到前缀是"custom.datasource."的属性列表值.
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment,"custom.datasource.");
        //获取到所有数据源的名称.
        String dsPrefixs =propertyResolver.getProperty("names");
        String[] dsPrefixsArr =dsPrefixs.split(",");
        for(String dsPrefix:dsPrefixsArr){
            Map<String,Object>dsMap = propertyResolver.getSubProperties(dsPrefix +".");
            //存放到一个map集合中，之后在注入进行使用.
            dataSourceMap.put(dsPrefix, dsMap);
        }
    }
}
