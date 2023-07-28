/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.bean;


import com.asa.demo.spring.rabbitmq.integration.annotation.AxRabbitMqPublisher;
import com.asa.demo.spring.rabbitmq.integration.common.AbstractMessageBody;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@AxRabbitMqPublisher(queue = "AxCalculateUADMessage", exchange = "TransactionExchange", routingKey = "AxCalculateUADMessage")
public class AxCalculateUADMessageBody extends AbstractMessageBody {
    @Override
    public String getRouteKey() {
        return null;
    }


    @Override
    public Map<String, Object> getMessageBody() {
        return null;
    }

    /**
     * 用户id
     */
    private String userId;

    /**
     * 时间日期
     */
    private LocalDateTime day;

    public static void main(String[] args) {
        AxCalculateUADMessageBody messageBody = new AxCalculateUADMessageBody();
        System.out.println(messageBody.getMessageId());
    }
}
