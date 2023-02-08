/**
 * @author: asx
 * @date: 2023/2/7
 * @descrition:
 */
package com.asa.demo.spring.message.rabbitmq.mq;


import com.asa.demo.spring.message.rabbitmq.annotation.AxRabbitMqProductor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AxRabbitMqProductor(queue = "ax-queue", exchange = "ax-exchange", routeKey = "")
public class AxTestMessageMq {
    private String name;
}
