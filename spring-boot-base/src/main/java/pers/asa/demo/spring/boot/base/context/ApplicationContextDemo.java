/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.asa.demo.spring.boot.base.inject.BeanByImport;
import pers.asa.demo.spring.boot.base.proxy.IDbService;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
public class ApplicationContextDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("pers.asa.demo.spring.boot.base");
        BeanByImport bean = context.getBean(BeanByImport.class);
        System.out.println(bean.test());
    }
}
