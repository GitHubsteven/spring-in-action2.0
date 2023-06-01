/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.common;

import java.util.Map;

public interface IMessageBody {
    /**
     * 获取路由
     *
     * @return 路由
     */
    String getRouteKey();

    /**
     * 获取消息体的id，保证唯一性
     *
     * @return 消息体的id
     */
    String getMessgeId();

    /**
     * 获取消息体信息
     *
     * @return 消息体信息
     */
    Map<String, Object> getMessageBody();
}
