package com.asa.demo.spring.mongo.comparison.service.driver;

import com.asa.demo.spring.mongo.comparison.BaseTest;
import com.asa.demo.spring.mongo.comparison.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JavaDriverServiceImplTest extends BaseTest {

    @Autowired
    private JavaDriverServiceImpl javaDriverService;

    @Test
    public void listAllCustomers() {
        javaDriverService.listAllCustomers().forEach(System.out::println);
    }

    @Test
    public void testCreate() {
        Customer customer = new Customer("data", "mongodb");
        javaDriverService.createCustomer(customer);
        List<Customer> customers = javaDriverService.listAllCustomers();
        Assert.assertEquals(4, customers.size());
    }
}