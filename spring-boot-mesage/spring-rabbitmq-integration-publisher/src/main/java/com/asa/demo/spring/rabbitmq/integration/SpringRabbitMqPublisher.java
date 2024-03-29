/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration;

import com.asa.demo.spring.rabbitmq.integration.annotation.AxRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AxRabbitMq
public class SpringRabbitMqPublisher {
    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitMqPublisher.class, args);
    }
}
