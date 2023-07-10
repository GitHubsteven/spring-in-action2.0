/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import pers.asa.demo.spring.boot.base.bean.SimpleBean;
import pers.asa.demo.spring.boot.base.inject.BeanByImport;

/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
@ComponentScan("pers.asa.demo.spring.boot.base")
@Import(BeanByImport.class)
public class AppConfig {
    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }
}
