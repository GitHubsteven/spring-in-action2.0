package com.asa.demo.spring.message.rabbitmq;

import com.asa.demo.spring.message.rabbitmq.component.Receiver;
import com.asa.demo.spring.message.rabbitmq.config.BeanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SendMqMessageTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;


    @Test
    public void testSendMessage() throws InterruptedException {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(BeanConfig.topicExchangeName, "foo.bar.baz",
                "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MICROSECONDS);
    }
}
