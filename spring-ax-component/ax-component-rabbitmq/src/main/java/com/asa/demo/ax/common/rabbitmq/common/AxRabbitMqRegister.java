/**
 * @author: asx
 * @date: 2023/2/5
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.common;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class AxRabbitMqRegister implements EnvironmentAware, ImportBeanDefinitionRegistrar {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes("com.asa.demo.spring.rabbitmq.integration.annotation.AxRabbitMqPublisher");
    }

    private void registerMq(){

    }
}
