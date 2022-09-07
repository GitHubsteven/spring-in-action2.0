package pers.asa.spring.loader.seq.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/8/6 18:48
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/8/6 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface AxService {
}

