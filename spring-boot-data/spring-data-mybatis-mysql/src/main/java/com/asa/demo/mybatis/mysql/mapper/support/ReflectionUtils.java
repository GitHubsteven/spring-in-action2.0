package com.asa.demo.mybatis.mysql.mapper.support;

import com.sun.xml.internal.ws.spi.db.FieldSetter;

import java.lang.reflect.Field;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 19:48 2019/10/23.
 */
public class ReflectionUtils {
    public static Field[] getFields(Class<?> clz) {
        clz.getDeclaredFields();
        return clz.getDeclaredFields();
    }
}