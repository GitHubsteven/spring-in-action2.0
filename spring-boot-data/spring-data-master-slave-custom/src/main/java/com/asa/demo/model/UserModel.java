/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "user")
public class UserModel {
    @Id
    private Integer id;
    private String name;
    private Integer age;
}
