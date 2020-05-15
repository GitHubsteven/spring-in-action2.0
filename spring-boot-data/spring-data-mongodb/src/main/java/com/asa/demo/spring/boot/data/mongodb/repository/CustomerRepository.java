package com.asa.demo.spring.boot.data.mongodb.repository;

import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/14
 * @descrition:
 */
public interface CustomerRepository extends MongoRepository<Customer,Long> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
