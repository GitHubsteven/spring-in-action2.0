package com.asa.demo.spring.data.jpa.h2.service;

import com.asa.demo.spring.data.jpa.h2.model.Customer;
import com.asa.demo.spring.data.jpa.h2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Long add(Customer customer) {
        Customer save = customerRepository.save(customer);
        return save.getId();
    }

    public List<Customer> listByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public List<Long> add(List<Customer> customers) {
        Iterable<Customer> savedAll = customerRepository.saveAll(customers);
        List<Long> savedIds = new ArrayList<>();
        savedAll.forEach(it -> savedIds.add(it.getId()));
        return savedIds;
    }
}
