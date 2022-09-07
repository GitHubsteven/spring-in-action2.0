package pers.asa.demo.spring.boot.base.inherit;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/13 19:15
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/13 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class DefaultInheritApiImpl implements InheritApi {
    @Override
    public String get(Integer id) {
        return "hello, " + id;
    }
}

