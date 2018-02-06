package com.aceyan.framework.startuprunner;

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
    @Override
    public void run(String... args) throws Exception {
        System.err.println("MyStartupRunner1");
    }
}
