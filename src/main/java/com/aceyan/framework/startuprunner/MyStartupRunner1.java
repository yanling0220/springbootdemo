package com.aceyan.framework.startuprunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 启动加载类
 *
 * @author yanling
 * @time 2018-01-24-15:50
 */
@Component
@Order(2)
public class MyStartupRunner1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyStartupRunner1.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("MyStartupRunner1");
    }
}
