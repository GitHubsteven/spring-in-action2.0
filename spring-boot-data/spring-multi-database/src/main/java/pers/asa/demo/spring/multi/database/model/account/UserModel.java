package pers.asa.demo.spring.multi.database.model.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/29 11:32
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/29 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Entity
@Table(schema = "account", name = "user")
@Setter
@Getter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private Integer age;

    private Integer generation;

    private String country;
}

