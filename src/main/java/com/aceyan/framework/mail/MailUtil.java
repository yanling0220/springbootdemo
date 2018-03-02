package com.aceyan.framework.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 邮件工具类
 *
 * @author yanling
 * @time 2018-03-02-13:52
 */
public class MailUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailUtil.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1828439778@qq.com");
        simpleMailMessage.setTo("308625960@qq.com");
        simpleMailMessage.setSubject("测试邮件<主题>！！！！");
        simpleMailMessage.setText("测试邮件内容。。。。。。");
        mailSender.send(simpleMailMessage);
    }

}
