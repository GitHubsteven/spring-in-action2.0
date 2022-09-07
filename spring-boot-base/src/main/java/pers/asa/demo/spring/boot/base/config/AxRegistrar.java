package pers.asa.demo.spring.boot.base.config;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import pers.asa.demo.spring.boot.base.factory.RegisterServiceFactory;
import pers.asa.demo.spring.boot.base.service.TestService;

import java.util.stream.IntStream;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 15:49
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AxRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private Environment environment;


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        IntStream.of(1, 2, 3, 4, 5).forEach(id -> {
            final AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(RegisterServiceFactory.class)
                    .addConstructorArgValue(id)
                    .getBeanDefinition();
            registry.registerBeanDefinition("RegisterServiceV" + id, beanDefinition);
        });
    }
}

