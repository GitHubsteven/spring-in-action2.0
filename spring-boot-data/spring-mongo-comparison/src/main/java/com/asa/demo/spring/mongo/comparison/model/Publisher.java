package com.asa.demo.spring.mongo.comparison.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher {
    @Id
    private ObjectId objectId;

    private String name;
}
