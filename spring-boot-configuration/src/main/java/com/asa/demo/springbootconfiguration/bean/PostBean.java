package com.asa.demo.springbootconfiguration.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 15:09 2020/3/5.
 */
@Setter
@Getter
public class PostBean implements Serializable {
    private String name;
    private Integer age;
    /**
     * 服务器是否成功接收
     */
    private Boolean received;

    private Object extendsInfo;
}