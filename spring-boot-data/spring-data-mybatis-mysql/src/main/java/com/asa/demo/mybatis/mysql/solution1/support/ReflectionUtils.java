package com.asa.demo.mybatis.mysql.solution1.support;

import com.asa.demo.mybatis.mysql.model.BlogModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 19:48 2019/10/23.
 */
public class ReflectionUtils {
    public static Field[] getFields(Class<?> clz) {
        List<Field> allFields = getAllFields(clz);
        return allFields.toArray(new Field[0]);
    }

    public static void main(String[] args) {
        BlogModel blogModel = new BlogModel();
        blogModel.setBaseId(12L);
        blogModel.setTitle("test title");
        Field[] fields = getFields(BlogModel.class);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(blogModel);
                if (value != null) {
                    System.out.println(String.format("field:%s,value:%s", field.getName(), value.toString()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    private static List<Field> getAllFields(Class<?> clz) {
        List<Field> fields = new ArrayList<>();
        while (clz != Object.class) {
            fields.addAll(Arrays.asList(clz.getDeclaredFields()));
            clz = clz.getSuperclass();
        }
        return fields;
    }
}