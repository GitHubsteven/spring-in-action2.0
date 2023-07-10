/**
 * @author: asx
 * @date: 2023/7/10
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.asa.demo.spring.boot.base.register.AxBeanRegistrar;

/**
 * @author: asx
 * @date: 2023/7/10
 * @descrition:
 */
public class RegisterConfigApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(RegistrarConfig.class);
        AxBeanRegistrar.BeanByRegistrar bean = context.getBean(AxBeanRegistrar.BeanByRegistrar.class);
        System.out.println(bean.test());
    }

}
