/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.controller;


import com.asa.demo.spring.rabbitmq.integration.common.Loggable;
import com.asa.demo.spring.rabbitmq.integration.config.DXLOrderMessageConfig;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController()
@RequestMapping("/rabbit-mq-sender")
public class SendMessageController extends Loggable {
    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        Map<String, Object> map = getMqMessage();
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
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
        rabbitTemplate.convertAndSend("NotExistExchangeExchange", "NotExistExchangeExchangeQueue", map);
        return "ok";
    }

    /**
     * exchange exist but queue not exist
     */
    @GetMapping("/sendNotExistQueueButExchangeMessage")
    public String sendNotExistQueueButExchangeMessage() {
        Map<String, Object> map = getMqMessage();
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("NotExistQueueButExchangeExchange", "NotExistQueueButExchangeQueue", map);
        return "ok";
    }

    /**
     * exchange exist but queue not exist
     */
    @GetMapping("/send-annotation-message")
    public String sendAnnotationMessage() {
        Map<String, Object> map = getMqMessage();
        //将消息携带绑定键值：AxCalculateUADMessage 发送到交换机AxCalculateUADMessage
        rabbitTemplate.convertAndSend("defaultExchange", "AxCalculateUADMessage", map);
        return "ok";
    }


    @GetMapping("/send-durable-queue-and-not")
    public String sendDurableQueueAndNot() {
        // 发送持久化mq
        Map<String, Object> durableMessage = getMqMessage();
        //将消息携带绑定键值：AxCalculateUADMessage 发送到交换机AxCalculateUADMessage
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", durableMessage);

        // 发送非持久化mq
        Map<String, Object> notDurableMessage = getMqMessage();
        //将消息携带绑定键值：AxCalculateUADMessage 发送到交换机AxCalculateUADMessage
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestNotDurableDirectRouting", notDurableMessage);
        return "ok";
    }

    @GetMapping("/create-order/{orderNo}")
    public String createOrder(@PathVariable("orderNo") String orderNo) {
        sendCheckMq(orderNo);
        return "ok";
    }

    /**
     * 模拟创建订单
     *
     * @param orderNo 订单号
     */
    @GetMapping("/save-order/{orderNo}")
    public String simulateCreateOrder(@PathVariable("orderNo") String orderNo) {
        try {
            insertOrderTable();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        // 发送mq去检测延时检测状态
        sendCheckMq(orderNo);
        return "ok";
    }

    private void insertOrderTable() throws InterruptedException {
        logger.info("start to create order ....");
        TimeUnit.SECONDS.sleep(1);
        logger.info("inserted to order table and occupy the stock");
    }

    private void sendCheckMq(String orderNo) {
        // 发送持久化mq
        Map<String, Object> orderMessage = getMqMessage();
        if (StringUtils.isEmpty(orderNo)) {
            orderNo = "order-" + RandomUtils.nextInt(1, 100);
        }
        orderMessage.put("orderNo", orderNo);
        //将消息携带绑定键值：AxCalculateUADMessage 发送到交换机AxCalculateUADMessage
        rabbitTemplate.convertAndSend(DXLOrderMessageConfig.ORDER_EXCHANGE, DXLOrderMessageConfig.ORDER_ROUTING_KEY, orderMessage);
    }


    @GetMapping("/message-in-transaction/{isException}")
    @Transactional(rollbackFor = Exception.class)
    public boolean messageInTransaction(@PathVariable("isException") Integer isException) {
        // 发送持久化mq
        Map<String, Object> durableMessage = getMqMessage();
        //将消息携带绑定键值：AxCalculateUADMessage 发送到交换机AxCalculateUADMessage
        rabbitTemplate.convertAndSend("TransactionExchange", "TransactionRouting", durableMessage);
        if (isException != null && isException == 1) {
            throw new RuntimeException("exception test!");
        }
        return true;
    }
}
