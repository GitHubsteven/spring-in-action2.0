/**
 * @author: asx
 * @date: 2023/3/2
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.config;

import com.asa.demo.spring.rabbitmq.integration.consumer.bean.BaseContainer;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BaseRabbitMqContainer {
    @Bean
    public BaseContainer BaseContainer(ObjectProvider<List<MessageListenerContainer>> containers) {
        BaseContainer baseContainer = new BaseContainer();
        baseContainer.setContainers(containers.getIfAvailable());
        return baseContainer;
    }
}
