package pers.asa.demo.spring.boot.base.register;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/6/25 14:13
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/6/25 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class TestRegistrar implements EnvironmentAware, ImportBeanDefinitionRegistrar, ImportSelector {
    private Environment environment;

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String prop = System.getProperty("myProp");
        if ("".equalsIgnoreCase(prop)) {
            return new String[0];
        } else {
            return new String[0];
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

    }
}

