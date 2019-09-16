package com.asa.demo.spring.boot.data.mongodb.repository;

import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfiguration.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSave(){
        Customer x_mongo = new Customer("mongodb", "x");
        Customer x_mysql = new Customer("mysql", "x");
        Customer y_mysql = new Customer("mongodb", "y");
        customerRepository.saveAll(Arrays.asList(x_mongo,x_mysql,y_mysql));
    }

    @Test
    public void findByFirstName() {
    }

    @Test
    public void findByLastName() {
    }
}