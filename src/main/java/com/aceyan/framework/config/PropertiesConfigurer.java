package com.aceyan.framework.config;

import com.aceyan.framework.properties.Wisely2Settings;
import com.aceyan.framework.properties.WiselySettings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanling
 * @time 2018-01-25-10:56
 */
@Configuration
@EnableConfigurationProperties({WiselySettings.class,Wisely2Settings.class})
public class PropertiesConfigurer {
}
