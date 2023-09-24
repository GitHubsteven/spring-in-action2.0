/**
 * @author: asx
 * @date: 2023/7/24
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.common;

import com.asa.demo.ax.common.rabbitmq.annotation.AxRabbitMqPublisher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: asx
 * @date: 2023/7/24
 * @descrition:
 */
@Aspect
public class AxMessageSenderAop {
    @Pointcut("execution(* com.asa.demo.ax.rabbitmq.integration.service.MqSendService.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void assignMessageValue(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (!(arg instanceof IMessageBody)) {
                AbstractMessageBody iMessageBody = (AbstractMessageBody) arg;
                AxRabbitMqPublisher annotation = iMessageBody.getClass().getAnnotation(AxRabbitMqPublisher.class);
                if (annotation != null) {
                    System.out.println(annotation.routingKey());
                    System.out.println(annotation.exchange());
                    System.out.println(annotation.queue());
                }
            }
        }

    }
}
