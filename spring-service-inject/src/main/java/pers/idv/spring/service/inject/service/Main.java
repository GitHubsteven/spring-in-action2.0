package pers.idv.spring.service.inject.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/27
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.subList(10, 11);
    }

    public static void getPage(int curPage, int pageSize, int size) {
        int pageFrom = (curPage - 1) * pageSize;
        int pageTo = pageFrom + pageSize;
    }
}
