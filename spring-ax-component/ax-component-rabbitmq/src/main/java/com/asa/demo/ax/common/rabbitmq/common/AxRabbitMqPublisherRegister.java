/**
 * @author: asx
 * @date: 2023/2/1
 * @descrition:
 */
package com.asa.demo.ax.common.rabbitmq.common;

import com.asa.demo.ax.common.rabbitmq.annotation.AxRabbitMqPublisher;
import com.asa.demo.ax.common.rabbitmq.bean.MqConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;

public class AxRabbitMqPublisherRegister implements BeanClassLoaderAware, ApplicationContextAware, ResourceLoaderAware, ImportBeanDefinitionRegistrar, BeanFactoryAware, EnvironmentAware {

    private ResourceLoader resourceLoader;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    private Environment environment;

    private ClassLoader classLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
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
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * 构造Class扫描器，设置了只扫描顶级接口，不扫描内部类
     *
     * @return
     */
    private ClassPathScanningCandidateComponentProvider getClassScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {

            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                if (beanDefinition.getMetadata().isIndependent()) {
                    try {
                        Class<?> target = ClassUtils.forName(beanDefinition.getMetadata().getClassName(), classLoader);
                        return !target.isAnnotation();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return false;
            }
        };
    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
      /*
        扫描指定包下带有AxRabbitMqPublisher注解的类
         */
        ClassPathScanningCandidateComponentProvider classScanner = getClassScanner();
        classScanner.setResourceLoader(this.resourceLoader);
        //指定只关注标注了@AxRabbitMqPublisher注解的接口
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(AxRabbitMqPublisher.class);
        classScanner.addIncludeFilter(annotationTypeFilter);
        //指定扫描的基础包
        String basePack = "com.asa.demo.spring";
        Set<BeanDefinition> beanDefinitionSet = classScanner.findCandidateComponents(basePack);
        /*
        注册到spring ioc容器中
         */
        for (BeanDefinition beanDefinition : beanDefinitionSet) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                registerBeans(((AnnotatedBeanDefinition) beanDefinition));
            }
        }
    }

    private void registerBeans(AnnotatedBeanDefinition beanDefinition) {
        String annotationName = AxRabbitMqPublisher.class.getName();
        AnnotationMetadata metadata = beanDefinition.getMetadata();
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
        Exchange exchange = new DirectExchange(exchangeName);
        ((DefaultListableBeanFactory) this.beanFactory).registerSingleton(exchangeName, exchange);
        // 注册队列
        Queue queue = new Queue(queueName);
        ((DefaultListableBeanFactory) this.beanFactory).registerSingleton(queueName, queue);
        // 注册binding关系
        String routingKey = (String) annotationAttributes.get("routingKey");
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
        ((DefaultListableBeanFactory) this.beanFactory).registerSingleton("" + binding.hashCode(), binding);
    }
}
