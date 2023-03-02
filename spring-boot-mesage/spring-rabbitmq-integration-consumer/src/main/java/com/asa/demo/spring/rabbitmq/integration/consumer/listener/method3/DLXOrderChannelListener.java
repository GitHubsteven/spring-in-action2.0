/**
 * @author: asx
 * @date: 2023/3/2
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.listener.method3;

import com.asa.demo.spring.rabbitmq.integration.consumer.common.Loggable;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class DLXOrderChannelListener extends Loggable implements ChannelAwareMessageListener {
    @RabbitListener(queues = "dlx-order-queue")
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String s = new String(message.getBody(), StandardCharsets.UTF_8);
        logger.info("订单dead letter queue[dead letter queue]订单消费者收到消息  : " + s);
        logger.info("开始处理超时的订单.....");
        logger.info("结束处理超时的订单.....");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
