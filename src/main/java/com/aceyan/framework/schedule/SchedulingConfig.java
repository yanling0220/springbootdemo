package com.aceyan.framework.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

/**
 * 定时任务
 *
 * @author yanling
 * @time 2018-01-10-18:43
 */
@Configuration
//@EnableScheduling
public class SchedulingConfig {
    //@Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
    public void scheduler(HttpRequestHandlerServlet servlet) {
        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
    }
}
