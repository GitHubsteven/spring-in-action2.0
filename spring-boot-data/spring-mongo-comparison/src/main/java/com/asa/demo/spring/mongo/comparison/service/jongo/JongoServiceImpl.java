package com.asa.demo.spring.mongo.comparison.service.jongo;

import com.asa.demo.spring.mongo.comparison.model.Customer;
import com.asa.demo.spring.mongo.comparison.service.IMongoService;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class JongoServiceImpl implements IMongoService {
    private final MongoCollection customers;

    public JongoServiceImpl(MongoClient client) {
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


    private <T> List<T> cursor2List(MongoCursor<T> cursor) {
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
