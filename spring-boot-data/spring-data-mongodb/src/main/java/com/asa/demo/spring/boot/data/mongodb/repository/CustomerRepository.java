package com.asa.demo.spring.boot.data.mongodb.repository;

import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/14
 * @descrition:
 */
public interface CustomerRepository extends MongoRepository<Customer, Long> {
    /**
     * 通过名来查找
     *
     * @param firstName 名
     * @return 用户
     */
    Customer findByFirstName(String firstName);

    /**
     * 通过姓来查找
     *
     * @param lastName 姓
     * @return 用户
     */
    List<Customer> findByLastName(String lastName);


}
