/**
 * @author: asx
 * @date: 2023/7/10
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.register;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: asx
 * @date: 2023/7/10
 * @descrition:
 */
public class AxBeanRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

        beanDefinition.setBeanClass(BeanByRegistrar.class);
        registry.registerBeanDefinition("BeanByRegistrar", beanDefinition);
    }


    public static class BeanByRegistrar {
        public String test() {
            return "BeanByRegistrar";
        }
    }
}
