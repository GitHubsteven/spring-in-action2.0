/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public abstract class AbstractMessageBody implements IMessageBody {
    /**
     * 消息id
     */
    private String messageId;
    /**
     * 生成的时间
     */
    private LocalDateTime createTime;

    /**
     * 延迟消费，dlx会用到
     */
    private long delayTimeS;
}
