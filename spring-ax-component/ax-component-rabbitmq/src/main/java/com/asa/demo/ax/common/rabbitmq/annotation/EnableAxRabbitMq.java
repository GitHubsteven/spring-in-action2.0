package com.asa.demo.ax.common.rabbitmq.annotation;

import com.asa.demo.ax.common.rabbitmq.common.AxRabbitMqPublisherRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(AxRabbitMqPublisherRegister.class)
public @interface EnableAxRabbitMq {
}
