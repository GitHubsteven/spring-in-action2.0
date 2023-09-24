/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TransactionRabbitConfig {
    @Bean
    public Queue TransactionQueue(){
        return new Queue("TransactionQueue",true);
    }

    /**
     * Direct交换机 起名：TransactionExchange
     */
    @Bean
    DirectExchange TransactionExchange() {
        return new DirectExchange("TransactionExchange", true, false);
    }

    @Bean("transactionBind")
    Binding bindingDirect() {
        return BindingBuilder.bind(TransactionQueue())
                .to(TransactionExchange())
                .with("TransactionRouting");
    }
}
