/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.service;

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
