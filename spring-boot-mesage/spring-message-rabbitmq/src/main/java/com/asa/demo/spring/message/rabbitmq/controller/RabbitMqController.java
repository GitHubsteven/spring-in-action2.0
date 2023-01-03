/**
 * @author: asx
 * @date: 2022/12/10
 * @descrition:
 */
package com.asa.demo.spring.message.rabbitmq.controller;

import com.asa.demo.spring.message.rabbitmq.config.BeanConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rabbit-mq")
public class RabbitMqController {
    private final RabbitTemplate rabbitTemplate;

    public RabbitMqController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @PostMapping("/send-message")
    public void sendMessage(@RequestBody Map<String,Object> messageBody){
        rabbitTemplate.convertAndSend(BeanConfig.topicExchangeName,
                "foo.bar.baz", "Hello from RabbitMQ!");
    }
}
