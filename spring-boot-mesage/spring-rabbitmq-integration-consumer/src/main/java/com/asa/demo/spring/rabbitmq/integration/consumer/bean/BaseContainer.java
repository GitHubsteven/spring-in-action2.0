/**
 * @author: asx
 * @date: 2023/3/2
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;

import java.util.List;

@Setter
@Getter
@ToString
public class BaseContainer {
    List<MessageListenerContainer> containers;
}
