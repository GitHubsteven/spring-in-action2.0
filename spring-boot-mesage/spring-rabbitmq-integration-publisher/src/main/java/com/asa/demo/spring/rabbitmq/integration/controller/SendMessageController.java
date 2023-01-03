/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.controller;


import com.asa.demo.spring.rabbitmq.integration.bean.MqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController()
@RequestMapping("/rabbit-mq-sender")
public class SendMessageController {
    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        Map<String, Object> map = getMqMessage();
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange",
                "TestDirectRouting", map);
        return "ok";
    }

    private static Map<String, Object> getMqMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>(3);
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        return map;
    }

    /**
     * exchange and queue not exist
     */
    @GetMapping("/sendNotExistExchangeMessage")
    public String sendNotExistExchangeMessage() {
        Map<String, Object> map = getMqMessage();
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange",
                "TestDirectRouting", map);
        return "ok";
    }

    /**
     * exchange exist but queue not exist
     */
    @GetMapping("/sendNotExistQueueButExchangeMessage")
    public String sendNotExistQueueButExchangeMessage() {
        Map<String, Object> map = getMqMessage();
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("NotExistQueueButExchangeExchange",
                "NotExistQueueButExchangeQueue", map);
        return "ok";
    }

}
