package com.asa.demo.mybatis.mysql.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Authoer: asa.x
 * @Date: 2019/10/7
 * @Descrition:
 */
@Setter
@Getter
public class BaseModel<T> {
    private T id;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifiedTime;
}
