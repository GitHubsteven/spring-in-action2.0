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

@Setter
@Getter
@AxRabbitMqPublisher(queue = "AxCalculateUADMessage", routingKey = "AxCalculateUADMessage")
public class AxCalculateUADMessageBody extends AbstractMessageBody {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 时间日期
     */
    private LocalDateTime day;
}
