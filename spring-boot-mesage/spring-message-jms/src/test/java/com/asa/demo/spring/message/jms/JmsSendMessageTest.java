package com.asa.demo.spring.message.jms;

import com.asa.demo.spring.message.jms.bean.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class JmsSendMessageTest {
    @Autowired
    private JmsTemplate jmsTemplate;


    @Test
    public void testSendMail() {
        jmsTemplate.convertAndSend("mailbox", new Email("test@example.com", "test worked!"));
    }
}
