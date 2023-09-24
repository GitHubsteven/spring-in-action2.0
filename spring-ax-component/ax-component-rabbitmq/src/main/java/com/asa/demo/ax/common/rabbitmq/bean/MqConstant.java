/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.bean;

public interface MqConstant {

    interface Exchange{
        String TEST_DIRECT_EXCHANGE = "TestDirectExchange";

        String DEFAULT_EXCHANGE = "defaultExchange";

    }

    interface Queue{
        String TEST_DIRECT_ROUTING = "TestDirectRouting";

        String EXPIRED_ORDER = "expired-order";
        interface  DXL{

        }
    }


}
