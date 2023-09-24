package com.asa.demo.ax.common.rabbitmq.annotation;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AxRabbitMqPublisher {
    /**
     * 声明队列名称
     *
     * @return 队列名称
     */
    String queue() default "";

    /**
     * 交换机名称
     *
     * @return 交换机名称
     */
    String exchange() default "";

    /**
     * binding路由路径
     *
     * @return binding路由路径
     */
    String routingKey() default "";
}
