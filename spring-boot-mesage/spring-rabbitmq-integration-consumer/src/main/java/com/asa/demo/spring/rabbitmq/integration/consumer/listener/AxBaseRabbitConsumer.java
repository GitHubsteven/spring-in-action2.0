/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

public interface AxBaseRabbitConsumer {

    @RabbitHandler
    void process();
}
