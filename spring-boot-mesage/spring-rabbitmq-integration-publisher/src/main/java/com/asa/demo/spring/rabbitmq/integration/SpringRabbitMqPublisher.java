/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitMqPublisher {
    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitMqPublisher.class, args);
    }
}
