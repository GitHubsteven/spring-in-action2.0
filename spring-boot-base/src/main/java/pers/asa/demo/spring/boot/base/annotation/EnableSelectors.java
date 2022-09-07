package pers.asa.demo.spring.boot.base.annotation;

import org.springframework.context.annotation.Import;
import pers.asa.demo.spring.boot.base.config.AxSelector;

import java.lang.annotation.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/20 15:38
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/20 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AxSelector.class)
public @interface EnableSelectors {
}

