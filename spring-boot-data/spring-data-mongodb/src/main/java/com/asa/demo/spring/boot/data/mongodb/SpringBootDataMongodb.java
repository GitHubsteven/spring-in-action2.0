package com.asa.demo.spring.boot.data.mongodb;

import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import com.asa.demo.spring.boot.data.mongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author: asa.x
 * @date: 2019/9/14
 * @descrition:
 */
@SpringBootApplication
public class SpringBootDataMongodb implements  CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMongodb.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------->mongodb clear all records and save new added records!");
        customerRepository.deleteAll();
        Customer x_mongo = new Customer("mongodb", "x");
        Customer x_mysql = new Customer("mysql", "x");
        Customer y_mysql = new Customer("mongodb", "y");
        customerRepository.saveAll(Arrays.asList(x_mongo,x_mysql,y_mysql));
        System.out.println("--------->mongodb find all records!");
        customerRepository.findAll().forEach(System.out::println);
        System.out.println("----------");
        System.out.println("----------find the last name is x");
        customerRepository.findByLastName("x").forEach(System.out::println);
    }
}
