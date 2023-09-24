package com.asa.demo.ax.common.rabbitmq.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        AxRabbitMqConProperties.class
})
public class AxRabbitMqConfig {
}
