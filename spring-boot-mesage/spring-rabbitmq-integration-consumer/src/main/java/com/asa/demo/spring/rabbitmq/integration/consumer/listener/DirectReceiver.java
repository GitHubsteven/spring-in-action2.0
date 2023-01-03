/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.listener;

import com.asa.demo.spring.rabbitmq.integration.consumer.common.Loggable;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RabbitListener(queues = "TestDirectQueue")   // 指定监听的队列
public class DirectReceiver extends Loggable {
    @RabbitHandler
    public void process(Object testMessage) {
        try {
            TimeUnit.SECONDS.sleep(1);
            logger.info("DirectReceiver[TestDirectQueue]消费者收到消息  : " + testMessage.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
