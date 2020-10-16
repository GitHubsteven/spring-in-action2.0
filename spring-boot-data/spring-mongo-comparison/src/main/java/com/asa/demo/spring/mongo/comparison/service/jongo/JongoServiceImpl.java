package com.asa.demo.spring.mongo.comparison.service.jongo;

import com.asa.demo.spring.mongo.comparison.model.Customer;
import com.asa.demo.spring.mongo.comparison.service.IMongoService;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.asa.demo.spring.mongo.comparison.utils.MongoUtils.cursor2List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class JongoServiceImpl implements IMongoService<Customer> {
    private final MongoCollection customers;

    public JongoServiceImpl(MongoClient client, MongoProperties mongoProperties) {
        Jongo jongo = new Jongo(client.getDB("spring-data"));
        this.customers = jongo.getCollection("customer");
    }


    @Override
    public List<Customer> listAllCustomers() {
        MongoCursor<Customer> cursor = customers.find().as(Customer.class);
        return cursor2List(cursor);
    }

    @Override
    public String create(Customer customer) {
        customers.save(customer);
        return customer.get_id();
    }

    @Override
    public Customer get(String id) {
        return customers.findOne(new ObjectId(id)).as(Customer.class);
    }

    public List<Customer> listPages(String name, int pageSize, int curPage) {
        int skip = pageSize * (curPage - 1);
        MongoCursor<Customer> page = customers.find("{lastName:{$regex: #}}", name)
                .skip(skip)
                .limit(pageSize)
                .as(Customer.class);
        return cursor2List(page);
    }

    public List<Customer> aggregate() {
        customers.distinct("lastName").as(String.class);
        return null;
    }
}
