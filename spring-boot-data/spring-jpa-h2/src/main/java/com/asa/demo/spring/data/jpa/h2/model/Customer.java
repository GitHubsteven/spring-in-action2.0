package com.asa.demo.spring.data.jpa.h2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/13
 * @Descrition: Here you have a Customer class with three attributes, the id, the firstName, and the lastName. You also have two constructors. The default constructor only exists for the sake of JPA. You won’t use it directly, so it is designated as protected.
 * The other constructor is the one you’ll use to create instances of Customer to be saved to the database.
 */
@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
