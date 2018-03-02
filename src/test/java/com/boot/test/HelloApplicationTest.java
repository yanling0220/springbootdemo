package com.boot.test;

import com.Application;
import com.alibaba.fastjson.JSON;
import com.boot.entity.User;
import com.boot.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 测试类
 *
 * @author yanling
 * @time 2018-01-29-9:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class HelloApplicationTest {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Test
    public void test(){
        assertEquals("hello",userService.hello());
    }
    @Test
    public void test1(){
        List<User> users = userService.queryAllUser();
        System.err.println(JSON.toJSONString(users));
        assertNotNull(users);
    }

    /**
     * properties 文件中
     * spring.mail.password 设置密码， 如果登录密码不行 则可以获取安全密码进行登录
     */
    @Test
    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("308625960@qq.com");
        simpleMailMessage.setTo("1828439778@qq.com");
        simpleMailMessage.setSubject("测试邮件<主题>！！！！");
        simpleMailMessage.setText("测试邮件内容。。。。。。");
        mailSender.send(simpleMailMessage);
    }

    /**
     * 发送带附件 邮件
     */
    @Test
    public void sendAttachmentsEmail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("308625960@qq.com");
        helper.setTo("1828439778@qq.com");
        helper.setSubject("测试附件邮件<主题>！！！");
        helper.setText("测试附件邮件内容。。。");

        FileSystemResource file1 = new FileSystemResource("D:/image002.jpg");
        helper.addAttachment("测试附件1.jpg",file1);
        FileSystemResource file2 = new FileSystemResource("D:/1.jpg");
        helper.addAttachment("测试附件2.jpg",file2);
        mailSender.send(mimeMessage);
    }

    /**
     * 邮件中使用静态资源
     * @throws MessagingException
     */
    @Test
    public void sendInlineMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("308625960@qq.com");
        helper.setTo("1828439778@qq.com");
        helper.setSubject("测试静态资源邮件<主题>！！！");
        helper.setText("<body>这是图片：<imgsrc='cid:image002' /></body>");

        FileSystemResource file1 = new FileSystemResource("D:/image002.jpg");
        helper.addInline("image002",file1);
        mailSender.send(mimeMessage);
    }

    @Test
    public void sendTemplatesMail() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("308625960@qq.com");
        helper.setTo("1828439778@qq.com");
        helper.setSubject("模板邮件测试<主题>");
        Map<String, Object> model = new HashMap<>();
        model.put("username","李四");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);

        cfg.setClassForTemplateLoading(this.getClass(),"/templates");
        Template template = cfg.getTemplate("mail.ftl");

        String templatesHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
        helper.setText(templatesHtml);
        mailSender.send(mimeMessage);
    }

}
