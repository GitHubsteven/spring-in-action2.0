package com.asa.demo.spring.boot.mysql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Authoer: asa.x
 * @Date: 2019/12/17
 * @Descrition:
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
