package com.asa.demo.spring.message.rabbitmq.annotation;

public @interface AxRabbitMqProductor {
    String queue() default "";

    String exchange() default "";

    String routeKey() default "";
}
