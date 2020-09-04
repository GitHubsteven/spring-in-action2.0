package com.asa.demo.mybatis.mysql.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: asa.x
 * @Date: 2019/10/7
 * @descrition:
 */
@Setter
@Getter
public class BaseModel<T> {
    private T id;
    private Long baseId;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifiedTime;
}
