package com.asa.demo.spring.mongo.comparison.service.driver;

import com.asa.demo.spring.mongo.comparison.model.Customer;
import com.asa.demo.spring.mongo.comparison.service.IMongoService;
import com.asa.demo.spring.mongo.comparison.utils.JacksonUtils;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class JavaDriverServiceImpl implements IMongoService {
    private final MongoCollection<Document> collection;

    public JavaDriverServiceImpl() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("spring-data");
        collection = database.getCollection("customer");

    }

    @Override
    public List<Customer> listAllCustomers() {
        MongoCursor<Document> iterator = collection.find().iterator();
        List<Customer> customers = new ArrayList<>();
        while (iterator.hasNext()) {
            customers.add(JacksonUtils.json2Bean(iterator.next().toJson(), Customer.class));
        }
        return customers;
    }

    public void createCustomer(Customer customer) {
        Document doc = new Document("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName());
//                .append("count", 1)
//                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
//                .append("info", new Document("x", 203).append("y", 102));
        collection.insertOne(doc);
    }
}
