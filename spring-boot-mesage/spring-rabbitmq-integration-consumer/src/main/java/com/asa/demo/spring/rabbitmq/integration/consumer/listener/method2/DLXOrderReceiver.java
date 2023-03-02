/**
 * @author: asx
 * @date: 2023/1/3
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.consumer.listener.method2;

//@Service
//@RabbitListener(queues = "dlx-order-queue")   // 指定监听的队列
//public class DXLOrderReceiver extends Loggable {
//    @RabbitHandler
//    public void process(Object orderMessage) {
//
//        String s = new String(((Message) orderMessage).getBody(), StandardCharsets.UTF_8);
//        logger.info("订单dead letter queue[dead letter queue]订单消费者收到消息  : " + s);
//        logger.info("开始处理超时的订单.....");
//        logger.info("结束处理超时的订单.....");
//    }
//}
