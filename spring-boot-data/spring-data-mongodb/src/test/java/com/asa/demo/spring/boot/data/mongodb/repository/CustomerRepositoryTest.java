package com.asa.demo.spring.boot.data.mongodb.repository;

import com.asa.demo.spring.boot.data.mongodb.SpringBootDataMongodb;
import com.asa.demo.spring.boot.data.mongodb.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = BeanConfiguration.class)
@SpringBootTest(classes = SpringBootDataMongodb.class)
public class CustomerRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSave() {
        Customer x_mongo = new Customer("mongodb", "x");
        Customer x_mysql = new Customer("mysql", "x");
        Customer y_mysql = new Customer("mongodb", "y");
        customerRepository.saveAll(Arrays.asList(x_mongo, x_mysql, y_mysql));
    }

    @Test
    public void findByFirstName() {
        Criteria criteria = Criteria.where("firstName").is("asa");
        Aggregation customerAgg = Aggregation.newAggregation(
                Aggregation.project("firstName", "lastName", "address"),
                Aggregation.match(criteria),
//                Aggregation.unwind("orders"),
//                Aggregation.group("buyerNick").first("buyerNick").as("buyerNick").first("mobile").as("mobile").
//                        first("address").as("address").sum("payment").as("totalPayment").sum("num").as("itemNum").count().as("orderNum"),
                Aggregation.sort(Sort.by(Sort.Order.asc("firstName"))),
                Aggregation.skip(0),
                Aggregation.limit(2)
        );
        AggregationResults<Customer> results = mongoTemplate.aggregate(customerAgg, "customer", Customer.class);
        List<Customer> customers = new ArrayList<>();
        Iterator<Customer> iterator = results.iterator();
        while (iterator.hasNext()) {
            customers.add(iterator.next());
        }
    }

    @Test
    public void findByLastName() {
        List<Customer> customers = customerRepository.findByLastName("x");
        customers.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Order.asc("firstName")));
        Example<Customer> example = Example.of(new Customer(null, "x"));
        Page<Customer> pageResult = customerRepository.findAll(example, pageRequest);
        for (Customer customer : pageResult.getContent()) {
            System.out.println(customer);
        }
    }

    @Test
    public void testCustomerQueryWith() {
        customerRepository.count();
    }
}