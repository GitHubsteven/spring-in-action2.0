package com.asa.demo.spring.boot.mysql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/13
 * @Descrition: This is the entity class which Hibernate will automatically translate into a table.
 * <strong> Hibernate will create the table if not exist </strong>
 */
@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;
}
