package com.asa.demo.spring.mongo.comparison.service.driver;

import com.asa.demo.spring.mongo.comparison.BaseTest;
import com.asa.demo.spring.mongo.comparison.model.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JavaDriverServiceImplTest extends BaseTest {

    @Autowired
    private JavaDriverServiceImpl javaDriverService;

    @Test
    public void listAllCustomers() {
        javaDriverService.listAllCustomers().forEach(System.out::println);
    }

    @Test
    public void testCreate() {
        Customer customer = new Customer("id_test2", "mongodb");
        String _id = javaDriverService.create(customer);
        System.out.println("---->_id: " + _id);
    }

    @Test
    public void testGet() {
        Customer customer = javaDriverService.get("5f86c6356ba6c81cd8c15210");
        System.out.println(customer.toString());
    }
}