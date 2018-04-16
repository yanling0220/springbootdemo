package com.boot.test;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author yanling
 * @time 2018-03-06-11:11
 */
@Service
@Profile("dev")
public class DevEmailServiceImpl implements EmailService {
    @Override
    public void send() {
        System.err.println("开发环境不发送邮件");
    }
}
