package com.asa.demo.spring.mongo.comparison.utils;

import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MongoUtils {
    public static <T> List<T> cursor2List(MongoCursor<T> cursor) {
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
