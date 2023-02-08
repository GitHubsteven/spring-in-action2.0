/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.bean;

public interface MqConstant {

    interface Exchange{
        String TEST_DIRECT_EXCHANGE = "TestDirectExchange";

        String DEFAULT_EXCHANGE = "defaultExchange";
    }

    interface Queue{
        String TEST_DIRECT_ROUTING = "TestDirectRouting";
    }

}
