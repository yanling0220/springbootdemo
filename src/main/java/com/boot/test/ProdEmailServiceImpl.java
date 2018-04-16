package com.boot.test;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author yanling
 * @time 2018-03-06-11:13
 */
@Service
@Profile("prod")
public class ProdEmailServiceImpl implements EmailService{
    @Override
    public void send() {
        System.err.println("生成环境发送邮件");
    }
}
