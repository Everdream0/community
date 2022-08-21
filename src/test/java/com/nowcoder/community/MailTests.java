package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    // 要用thymeleaf模板就要注入模板引擎
    @Autowired
    private TemplateEngine templateEngine;


//    @Test
//    public void testTextMail() {
//        mailClient.sendMail("wutao1811@163.com", "TEST", "Welcome.");
//    }

    /**
     * 把要传的thymeleaf模板内容放进content然后传给模板
     */
//    @Test
//    public void testHtmlMail() {
//        Context context = new Context();
//        context.setVariable("username", "sunday");
//
//        String content = templateEngine.process("/mail/demo", context);
//        System.out.println(content);
//
//        mailClient.sendMail("wutao1811@163.com", "HTML", content);
//    }

}
