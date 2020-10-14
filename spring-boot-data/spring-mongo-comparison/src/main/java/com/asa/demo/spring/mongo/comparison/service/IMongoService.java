package com.asa.demo.spring.mongo.comparison.service;

import com.asa.demo.spring.mongo.comparison.model.Customer;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface IMongoService {
    List<Customer> listAllCustomers();

    String create(Customer customer);

    Customer get(String id);
}
