/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    /**
     * Direct交换机 起名：TestDirectExchange
     */
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange", true, false);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue())
                .to(TestDirectExchange())
                .with("TestDirectRouting");
    }

    /**
     * Direct交换机 起名：TestDirectExchange
     */
    @Bean
    DirectExchange NotExistQueueButExchange() {
        return new DirectExchange("NotExistQueueButExchangeExchange", true, false);
    }


}