/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMqConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.addAfterReceivePostProcessors(message -> {
            byte[] body = message.getBody();
            log.info("received body is:{}", body);
            return message;
        });
        // set confirm callback
        rabbitTemplate.setConfirmCallback((correlationData, isAck, cause) -> {
            System.out.println("ConfirmCallback:     " + "相关数据[correlationData]：" + correlationData);
            System.out.println("ConfirmCallback:     " + "确认情况[isAck]：" + isAck);
            System.out.println("ConfirmCallback:     " + "原因[cause]：" + cause);
        });
        // set return callback
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("ReturnCallback:     " + "消息[message]：" + message);
            System.out.println("ReturnCallback:     " + "回应码[replyCode]：" + replyCode);
            System.out.println("ReturnCallback:     " + "回应信息[replyText]：" + replyText);
            System.out.println("ReturnCallback:     " + "交换机[exchange]：" + exchange);
            System.out.println("ReturnCallback:     " + "路由键[routingKey]：" + routingKey);

        });
        return rabbitTemplate;
    }
}
