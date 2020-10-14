package com.asa.demo.spring.mongo.comparison.model;

import lombok.Getter;
import lombok.Setter;
import org.jongo.marshall.jackson.oid.MongoObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: asa.x
 * @date: 2019/9/14
 * @descrition:
 */
@Setter
@Getter
@Document(collection = "customer")
public class Customer {
    @MongoObjectId
    public String _id;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                _id, firstName, lastName);
    }

}