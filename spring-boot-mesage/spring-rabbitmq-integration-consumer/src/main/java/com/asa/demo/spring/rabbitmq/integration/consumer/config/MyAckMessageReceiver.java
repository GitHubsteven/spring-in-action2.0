/**
 * @author: asx
 * @date: 2023/1/10
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.config;

import com.asa.demo.spring.rabbitmq.integration.consumer.utils.JsonUtils;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MyAckMessageReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        // 获取consumerQueue，根绝routeKey来决定处理业务
        String consumerQueue = message.getMessageProperties().getConsumerQueue();
        String strictRequired = null;
        try {
            byte[] body = message.getBody();
            String json = new String(body, StandardCharsets.UTF_8);
            Map<String, Object> msgMap = JsonUtils.toMap(json);
            strictRequired = (String) msgMap.get("strictRequired");
            business(consumerQueue, msgMap);
            //第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            boolean isRequeue = strictRequired != null && strictRequired.contains("1");
            channel.basicReject(deliveryTag, isRequeue);
            e.printStackTrace();
        }

    }

    private static void business(String consumerQueue, Map<String, Object> msgMap) {
        String messageId = (String) msgMap.get("messageId");
        String messageData = (String) msgMap.get("messageData");
        String createTime = (String) msgMap.get("createTime");
        // TODO: 2023/1/10 消费队列不同，分配执行器不同
        System.out.println("  MyAckReceiver  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
        System.out.println("消费的主题消息来自：" + consumerQueue);
    }
}
