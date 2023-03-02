/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.listener.method2;

import com.asa.demo.spring.rabbitmq.integration.consumer.common.Loggable;
import com.asa.demo.spring.rabbitmq.integration.consumer.utils.JsonUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;
//
//@Service
//@RabbitListener(queues = "order-queue")   // 指定监听的队列
//public class OrderReceiver extends Loggable {
//
//    @RabbitHandler
//    public void process(Object orderMessage) {
//        business((Message) orderMessage);
//    }
//
//    private void business(Message orderMessage) {
//        String body = new String(orderMessage.getBody(), StandardCharsets.UTF_8);
//        Map<String, Object> messageInMap = JsonUtils.toMap(body);
//        String orderNo = (String) messageInMap.get("order-no");
//        if (orderNo != null && orderNo.contains("404")) {
//            throw new RuntimeException("illegal order no");
//        }
//        logger.info("DirectReceiver[OrderQueue]正常订单消费者收到消息  : " + orderMessage);
//    }
//
//
////    @RabbitHandler
////    public void process(Message message, Channel channel) throws Exception {
////        try {
////            business(message);
////            // 手动签收
////            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
////        } catch (Exception e) {
////            //拒绝消费消息（丢失消息） 给死信队列
////            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
////        }
////    }
//}
