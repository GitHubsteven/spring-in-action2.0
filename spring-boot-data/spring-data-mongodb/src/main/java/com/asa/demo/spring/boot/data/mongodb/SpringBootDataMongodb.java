package com.asa.demo.spring.boot.data.mongodb;

import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import com.asa.demo.spring.boot.data.mongodb.repository.CustomerRepository;
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
public class SpringBootDataMongodb implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public SpringBootDataMongodb(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMongodb.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------->mongodb clear all records and save new added records!");
        customerRepository.deleteAll();
        customerRepository.saveAll(Arrays.asList(new Customer("mongodb", "x"), new Customer("mysql", "x"), new Customer("mongodb", "y")));
        System.out.println("--------->mongodb find all records!");
        customerRepository.findAll().forEach(System.out::println);
        System.out.println("----------");
        System.out.println("----------find the last name is x");
        customerRepository.findByLastName("x").forEach(System.out::println);
    }
}
