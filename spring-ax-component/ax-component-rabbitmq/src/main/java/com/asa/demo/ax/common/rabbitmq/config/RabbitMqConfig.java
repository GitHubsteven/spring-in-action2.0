/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter(){
            @Override
            public void afterCommit() {
                super.afterCommit();
            }

            @Override
            public void beforeCommit(boolean readOnly) {
                super.beforeCommit(readOnly);
            }
        });
        // 设置是否为事务
//        rabbitTemplate.setChannelTransacted(true);
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
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
