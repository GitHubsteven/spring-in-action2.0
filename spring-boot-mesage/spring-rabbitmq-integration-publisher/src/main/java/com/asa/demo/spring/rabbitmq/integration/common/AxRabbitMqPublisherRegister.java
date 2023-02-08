/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.spring.rabbitmq.integration.common;

import com.asa.demo.spring.rabbitmq.integration.annotation.AxRabbitMqPublisher;
import com.asa.demo.spring.rabbitmq.integration.bean.MqConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class AxRabbitMqPublisherRegister implements ApplicationContextAware, ImportBeanDefinitionRegistrar, BeanFactoryAware {



    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public AxRabbitMqPublisherRegister() {
        System.out.println("AxRabbitMqPublisherRegister init ....");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        String annotationName = AxRabbitMqPublisher.class.getName();
        boolean isAxRabbitMqPublisher = metadata.hasAnnotation(annotationName);
        if (!isAxRabbitMqPublisher) return;
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(annotationName, true);
        if (CollectionUtils.isEmpty(annotationAttributes)) return;
        // 声明的队列名称
        String queueName = (String) annotationAttributes.get("queue");
        if (StringUtils.isEmpty(queueName)) {
            System.err.println("queue name error!");
            return;
        }
        String exchangeName = (String) annotationAttributes.get("exchange");
        if (StringUtils.isEmpty(exchangeName)) {
            exchangeName = MqConstant.Exchange.DEFAULT_EXCHANGE;
        }
        // 注册exchange
        Exchange exchange = null;
        try {
            exchange = (Exchange) applicationContext.getBean(exchangeName);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        if (exchange == null) exchange = new DirectExchange(exchangeName);

        ((DefaultListableBeanFactory) this.beanFactory).registerSingleton(exchangeName, exchange);
        // 注册队列
        Queue queue = null;
        try {
            queue = (Queue) applicationContext.getBean(queueName);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        if (queue == null) queue = new Queue(queueName);
        ((DefaultListableBeanFactory) this.beanFactory).registerSingleton(queueName, queue);
        // 注册binding关系
        String routingKey = (String) annotationAttributes.get("routingKey");
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
        ((DefaultListableBeanFactory) this.beanFactory)
                .registerSingleton("" + binding.hashCode(), binding);
    }
}
