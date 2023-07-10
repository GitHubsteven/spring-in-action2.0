/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.annotation;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
public @interface AxMessage {
    /**
     * 交换机名称
     * @return
     */
    String exchange() default "ax-exchange";

    /**
     * 队列名称
     * @return
     */
    String queueName() default "";

    /**
     * 路由
     * @return
     */
    String route();

    /**
     * 死信队列名称
     * @return
     */
    String DLQueueName();

    /**
     * 死信交换机
     * @return
     */
    String DLExchange();

    /**
     * 死信路由
     * @return
     */
    String DLRoute();
}
