package com.asa.demo.spring.data.jpa.h2.service;

import com.asa.demo.spring.data.jpa.h2.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void add() {
        Customer cus1 = new Customer("h2", "x");
        Customer cus2 = new Customer("mysql", "x");
        Customer cus3 = new Customer("h2", "y");
        List<Customer> customers = new ArrayList<>();
        customers.add(cus1);
        customers.add(cus2);
        customers.add(cus3);
        List<Long> ids = customerService.add(customers);
        System.out.println(ids);

        System.out.println(customerService.listByLastName("x"));
    }

    @Test
    public void listByLastName() {
        List<Customer> customers = customerService.listByLastName("x");
        System.out.println(customers);
    }
}