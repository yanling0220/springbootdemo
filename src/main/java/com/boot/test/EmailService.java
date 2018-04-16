package com.boot.test;


/**
 * 此类为测试 spring.profiles.active=prod 属性  在实现类中加入 @Profile 注解标注需要执行的实现
 * 例：若spring.profiles.active=dev 则 EmailService emailService 注入的为 com.boot.test.DevEmailServiceImpl 的事例，
 *    若spring.profiles.active=prod 则 EmailService emailService 注入的为 com.boot.test.ProdEmailServiceImpl 的事例.
 *    并分别执行内部方法.
 *
 *
 */
public interface EmailService {
    public void send();
}
