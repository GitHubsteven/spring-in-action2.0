/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.service;

import com.asa.demo.spring.rabbitmq.integration.annotation.AxRabbitMqPublisher;
import com.asa.demo.spring.rabbitmq.integration.bean.AxCalculateUADMessageBody;
import com.asa.demo.spring.rabbitmq.integration.common.IMessageBody;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MqSendService {

    private final RabbitTemplate rabbitTemplate;


    /**
     * 发送queue和routingKey不同的队列消息
     *
     * @param routingKey 路由
     */
    public void sendRouteKeyAndQueueNotSame(String routingKey) {
        Map<String, Object> mqMessage = getMqMessage();
        rabbitTemplate.convertAndSend(routingKey, mqMessage);
    }

    public void sendMessage(IMessageBody messageBody) {
        boolean isMessageBody = messageBody.getClass().isAnnotationPresent(AxRabbitMqPublisher.class);
        if (!isMessageBody)
            throw new RuntimeException("illegal message body!");
        AxRabbitMqPublisher annotation = messageBody.getClass().getAnnotation(AxRabbitMqPublisher.class);
        String routingKey = annotation.routingKey();
        rabbitTemplate.convertAndSend(routingKey, messageBody);
    }

    public void sendUADMessage() {
        AxCalculateUADMessageBody messageBody = new AxCalculateUADMessageBody();
        messageBody.setDay(LocalDateTime.now());
        messageBody.setUserId("123");
        sendMessage(messageBody);
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
}
