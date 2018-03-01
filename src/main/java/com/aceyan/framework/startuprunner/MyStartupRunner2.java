package com.aceyan.framework.startuprunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 启动加载类 2
 *
 * @author yanling
 * @time 2018-01-24-15:52
 */
@Component
@Order(1)
public class MyStartupRunner2 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyStartupRunner2.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("MyStartupRunner2");
    }
}
