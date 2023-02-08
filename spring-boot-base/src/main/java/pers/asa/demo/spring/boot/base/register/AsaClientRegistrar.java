package pers.asa.demo.spring.boot.base.register;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import pers.asa.demo.spring.boot.base.annotation.EnableAsaClients;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/4/28 14:03
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/4/28 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AsaClientRegistrar implements ImportBeanDefinitionRegistrar,
        ResourceLoaderAware, EnvironmentAware {

    private ResourceLoader resourceLoader;

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
//        try {
//            Class<?> aClass = resourceLoader.getClassLoader().loadClass("");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//        }
        annotationMetadata.getAnnotationAttributes(EnableAsaClients.class.getName(), true);
    }
}

