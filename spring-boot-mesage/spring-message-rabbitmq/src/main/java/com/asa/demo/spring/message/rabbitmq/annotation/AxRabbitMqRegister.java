/**
 * @author: asx
 * @date: 2023/2/7
 * @descrition:
 */
package com.asa.demo.spring.message.rabbitmq.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;

public class AxRabbitMqRegister implements EnvironmentAware, ApplicationContextAware, ImportBeanDefinitionRegistrar {
    private ApplicationContext context;
    private Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean isRabbitMq = importingClassMetadata.hasAnnotation(AxRabbitMqProductor.class.getName());
        if (!isRabbitMq) return;
        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));
    }
}
