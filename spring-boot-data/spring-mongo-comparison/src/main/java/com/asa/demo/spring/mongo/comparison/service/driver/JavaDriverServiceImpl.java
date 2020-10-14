package com.asa.demo.spring.mongo.comparison.service.driver;

import com.asa.demo.spring.mongo.comparison.model.Customer;
import com.asa.demo.spring.mongo.comparison.service.IMongoService;
import com.asa.demo.spring.mongo.comparison.utils.JacksonUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
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
    private final MongoCollection<Document> customerCollection;

    public JavaDriverServiceImpl(MongoDatabase database) {
        customerCollection = database.getCollection("customer");
    }

    @Override
    public List<Customer> listAllCustomers() {
        MongoCursor<Document> iterator = customerCollection.find().iterator();
        List<Customer> customers = new ArrayList<>();
        while (iterator.hasNext()) {
            customers.add(JacksonUtils.json2Bean(iterator.next().toJson(), Customer.class));
        }
        return customers;
    }

    @Override
    public String create(Customer customer) {
        Document doc = new Document("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName());
//                .append("count", 1)
//                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
//                .append("info", new Document("x", 203).append("y", 102));
        customerCollection.insertOne(doc);
        ObjectId id = doc.getObjectId("_id");
        return id.toString();
    }

    @Override
    public Customer get(String id) {
        Document doc = customerCollection.find(BasicDBObject.parse(String.format("{_id:{ \"$oid\" : \"%s\" }}", id))).first();
        return doc == null ? null : fromDoc2customer(doc);
    }

    public Customer fromDoc2customer(Document doc) {
        Customer customer = new Customer();
        customer.set_id(doc.getObjectId("_id").toString());
        customer.setFirstName(doc.getString("firstName"));
        customer.setLastName(doc.getString("lastName"));
        return customer;
    }
}
