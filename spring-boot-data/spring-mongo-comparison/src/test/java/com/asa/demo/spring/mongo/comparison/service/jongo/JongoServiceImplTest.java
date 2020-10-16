package com.asa.demo.spring.mongo.comparison.service.jongo;

import com.asa.demo.spring.mongo.comparison.BaseTest;
import com.asa.demo.spring.mongo.comparison.model.Address;
import com.asa.demo.spring.mongo.comparison.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JongoServiceImplTest extends BaseTest {
    @Autowired
    private JongoServiceImpl jongoService;

    @Test
    public void listAllCustomers() {
        List<Customer> customers = jongoService.listAllCustomers();
        customers.forEach(System.out::println);
    }

    @Test
    public void create() {
        Address address = new Address();
        address.setProvince("sh");
        address.setCity("sh");
        address.setArea("zhangjiangzhen");
        Customer customer = new Customer("ppx", "x");
        customer.setAddress(address);
        String _id = jongoService.create(customer);

        System.out.println(_id);
    }

    @Test
    public void get() {
        Customer customer = jongoService.get("5f86c6356ba6c81cd8c15210");
        System.out.println(customer);
    }

    @Test
    public void selectPage() {
        List<Customer> customers = jongoService.listPages("x", 5, 2);
        Assert.assertEquals(0, customers.size());
    }
}