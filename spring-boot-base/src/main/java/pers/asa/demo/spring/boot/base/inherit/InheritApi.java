package pers.asa.demo.spring.boot.base.inherit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/13 19:11
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/13 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface InheritApi {

    @GetMapping("/{id}")
    String get(@PathVariable("id") Integer id);
}
