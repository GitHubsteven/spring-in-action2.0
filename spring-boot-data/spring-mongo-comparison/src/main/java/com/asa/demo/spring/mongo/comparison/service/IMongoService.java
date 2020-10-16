package com.asa.demo.spring.mongo.comparison.service;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IMongoService<T> {

    List<T> listAllCustomers();

    String create(T customer);

    T get(String id);

}
