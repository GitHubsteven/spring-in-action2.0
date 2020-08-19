package com.asa.demo.spring.boot.data.mongodb.service;

import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import com.asa.demo.spring.boot.data.mongodb.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class CustomerServiceImpl implements IService<Customer, CustomerRepository> {
    @Override
    public void save(Customer model) {

    }
}
