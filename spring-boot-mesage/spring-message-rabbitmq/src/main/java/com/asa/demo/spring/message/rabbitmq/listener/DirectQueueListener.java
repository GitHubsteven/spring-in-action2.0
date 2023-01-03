/**
 * @author: asx
 * @date: 2022/12/10
 * @descrition:
 */
package com.asa.demo.spring.message.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "test-queue")
public class DirectQueueListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println(message.toString());
    }
}
