package com.asa.demo.spring.data.jpa.h2.repository;

import com.asa.demo.spring.data.jpa.h2.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
