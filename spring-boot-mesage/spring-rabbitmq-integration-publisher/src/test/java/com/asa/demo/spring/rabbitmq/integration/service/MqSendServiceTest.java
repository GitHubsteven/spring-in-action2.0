package com.asa.demo.spring.rabbitmq.integration.service;

import com.asa.demo.spring.rabbitmq.integration.ApplicationTest;
import com.asa.demo.spring.rabbitmq.integration.bean.AxOrderCheckMessage;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: asx
 * @date: 2023/7/24
 * @descrition:
 */
public class MqSendServiceTest extends ApplicationTest {
    @Autowired
    private MqSendService mqSendService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendUADMessage() {
        mqSendService.sendUADMessage();
    }

    @Test
    public void test() {
        AxOrderCheckMessage message = new AxOrderCheckMessage();
        message.setOrderNo("orderNo-" + RandomUtils.nextInt(1, 100));
        mqSendService.sendMessage(message);
    }

}