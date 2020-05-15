package com.asa.demo.mybatis.mysql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 10:56 2019/10/16.
 */
@Setter
@Getter
@ToString
public class CountUser implements Serializable {
    private String name;
    private int count;
}