/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.asa.demo.spring.boot.base.bean.SimpleBean;
import pers.asa.demo.spring.boot.base.inject.BeanByImport;
import pers.asa.demo.spring.boot.base.service.TestService;

/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
public class ApplicationByConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanByImport bean = context.getBean(BeanByImport.class);
        System.out.println(bean.test());

        TestService testService = context.getBean(TestService.class);
        System.out.println(testService.test());

        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        System.out.println(simpleBean.test());
    }
}
