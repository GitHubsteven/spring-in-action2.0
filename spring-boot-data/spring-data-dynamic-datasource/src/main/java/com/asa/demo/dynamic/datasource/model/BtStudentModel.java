package com.asa.demo.dynamic.datasource.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xrb16
 * @TableName student
 */
@Data
@TableName("student_0")
public class BtStudentModel implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String code;

    private static final long serialVersionUID = 1L;
}