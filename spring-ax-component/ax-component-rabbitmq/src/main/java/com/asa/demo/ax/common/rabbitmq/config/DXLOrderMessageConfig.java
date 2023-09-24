/**
 * @author: asx
 * @date: 2023/2/20
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DXLOrderMessageConfig {

    public static final String DXL_ORDER_QUEUE = "dlx-order-queue";
    public static final String DXL_ORDER_EXCHANGE = "dlx-order-exchange";

    public static final String DXL_ORDER_KEY = "dlx-order-routingKey";

    public static final String ORDER_QUEUE = "order-queue";

    public static final String ORDER_ROUTING_KEY = "order-routingKey";

    public static final String ORDER_EXCHANGE = "order-exchange";

    @Bean
    Queue DXLOrderQueue() {
        return new Queue(DXL_ORDER_QUEUE, true, false, false);
    }

    @Bean
    DirectExchange DXLOrderExchange() {
        return new DirectExchange(DXL_ORDER_EXCHANGE, true, false);
    }

    @Bean
    Binding dlxBinding() {

        return BindingBuilder.bind(DXLOrderQueue()).to(DXLOrderExchange()).with(DXL_ORDER_KEY);
    }

    @Bean
    DirectExchange OrderExchange() {
        Map<String, Object> deadLetterParams = new HashMap<>(2);
        return new DirectExchange(ORDER_EXCHANGE, true, false, deadLetterParams);
    }

    @Bean
    Queue OrderQueue() {
        Map<String, Object> args = new HashMap<>(1);
        // ms,指定对应的死信队列配置，和该消息的有效期限
        args.put("x-message-ttl", 60000);  //为队列设置过期时间
//        x-max-length:队列最大容纳消息条数，大于该值，mq拒绝接受消息，消息进入死信队列
//        args.put("x-max-length", 5);
        args.put("x-dead-letter-exchange", DXL_ORDER_EXCHANGE);
        args.put("x-dead-letter-routing-key", DXL_ORDER_KEY);
        return new Queue(ORDER_QUEUE, true, false, false, args);
    }


    @Bean
    Binding bindingOrder() {
        return BindingBuilder.bind(OrderQueue()).to(OrderExchange()).with(ORDER_ROUTING_KEY);
    }
}
