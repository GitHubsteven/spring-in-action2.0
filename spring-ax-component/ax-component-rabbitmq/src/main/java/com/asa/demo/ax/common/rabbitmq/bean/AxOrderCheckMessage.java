/**
 * @author: asx
 * @date: 2023/7/24
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.bean;

import com.asa.demo.ax.common.rabbitmq.annotation.AxRabbitMqPublisher;
import com.asa.demo.ax.common.rabbitmq.common.AbstractMessageBody;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author: asx
 * @date: 2023/7/24
 * @descrition:
 */
@Setter
@Getter
@AxRabbitMqPublisher(queue = "AxOrderCheckMessage", routingKey = "AxOrderCheckMessage")
public class AxOrderCheckMessage extends AbstractMessageBody {
    private String orderNo;

    @Override
    public String getRouteKey() {
        return null;
    }

    @Override
    public Map<String, Object> getMessageBody() {
        return null;
    }
}
