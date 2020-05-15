package com.asa.demo.spring.boot.mysql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: asa.x
 * @date: 2019/12/17
 * @descrition:
 */
@Setter
@Getter
@Accessors(chain = true)
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private String sessionId;
    private String remark;
}
