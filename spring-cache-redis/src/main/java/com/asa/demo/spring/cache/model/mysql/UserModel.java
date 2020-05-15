package com.asa.demo.spring.cache.model.mysql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition: This is the entity class which Hibernate will automatically translate into a table.
 * <strong> Hibernate will create the table if not exist </strong>
 */
@Entity(name = "user")
@Setter
@Getter
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;
}
