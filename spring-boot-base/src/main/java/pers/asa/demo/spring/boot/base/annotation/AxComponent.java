package pers.asa.demo.spring.boot.base.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 18:44
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
public @interface AxComponent {
    /**
     * 如果覆盖的方法有冲突，如@Configuration和@ComponentScan都有这个方法的话
     * 那么需要显示声明覆盖类为@ComponentScan
     */
    @AliasFor(
            annotation = ComponentScan.class
    )
    String[] value() default {};
}
