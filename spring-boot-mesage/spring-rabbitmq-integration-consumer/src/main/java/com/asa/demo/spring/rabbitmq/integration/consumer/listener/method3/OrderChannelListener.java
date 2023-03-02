/**
 * @author: asx
 * @date: 2023/3/2
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.listener.method3;

import com.asa.demo.spring.rabbitmq.integration.consumer.common.Loggable;
import com.asa.demo.spring.rabbitmq.integration.consumer.utils.JsonUtils;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class OrderChannelListener extends Loggable implements ChannelAwareMessageListener {
    @RabbitListener(queues = "order-queue")
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            business(message);
            // 手动签收
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            //拒绝消费消息（丢失消息） 给死信队列
            channel.basicReject(deliveryTag, false);
        }

    }

    private void business(Message orderMessage) {
        String body = new String(orderMessage.getBody(), StandardCharsets.UTF_8);
        Map<String, Object> messageInMap = JsonUtils.toMap(body);
        String orderNo = (String) messageInMap.get("orderNo");
        logger.info("DirectReceiver[OrderQueue]正常订单消费者收到消息  : " + orderNo);
        if (orderNo != null && orderNo.contains("404")) {
            throw new RuntimeException("illegal order no");
        }
    }
}
