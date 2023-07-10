/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import pers.asa.demo.spring.boot.base.jms.AxMessageBean;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
@Configuration
public class AxProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AxMessageBean) {
            System.out.println("init axMessage!");
        } else {
            System.out.println("init beanName: " + beanName);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AxMessageBean) {
            System.out.println("post process after init axMessage!");
        } else {
            System.out.println("post process after init axMessage! beanName: " + beanName);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
