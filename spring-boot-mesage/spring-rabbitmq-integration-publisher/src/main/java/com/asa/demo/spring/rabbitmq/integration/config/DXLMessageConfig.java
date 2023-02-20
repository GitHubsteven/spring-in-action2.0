/**
 * @author: asx
 * @date: 2023/2/20
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DXLMessageConfig {

    private static final String DXL_ORDER_QUEUE = "dxl-order-queue";
    private static final String DXL_ORDER_EXCHANGE = "dxl-order-exchange";

    private static final String DXL_ORDER_KEY = "dxl-order-routingKey";

    private static final String ORDER_QUEUE = "order-queue";

    private static final String ORDER_ROUTING_KEY = "order-routingKey";

    @Bean
    Queue DXLOrderQueue() {
        Map<String, Object> args = new HashMap<>(1);
        args.put("x-expires", 1800000);

        return new Queue(DXL_ORDER_QUEUE, true, false, false, args);
    }

    @Bean
    DirectExchange DXLOrderExchange() {
        return new DirectExchange(DXL_ORDER_EXCHANGE, true, false);
    }

    @Bean
    Binding dxlBinding() {

        return BindingBuilder.bind(OrderQueue()).to(OrderExchange()).with(DXL_ORDER_KEY);
    }

    @Bean
    DirectExchange OrderExchange() {
        Map<String, Object> deadLetterParams = new HashMap<>(2);
        deadLetterParams.put("x-dead-letter-exchange", DXL_ORDER_EXCHANGE);
        deadLetterParams.put("x-dead-letter-routing-key", DXL_ORDER_KEY);
        return new DirectExchange("order-exchange", true, false, deadLetterParams);
    }

    @Bean
    Queue OrderQueue() {
        return new Queue(ORDER_QUEUE, true);
    }


    @Bean
    Binding bindingDXLOrder() {

        return BindingBuilder.bind(OrderQueue()).to(OrderExchange()).with(ORDER_ROUTING_KEY);
    }
}
