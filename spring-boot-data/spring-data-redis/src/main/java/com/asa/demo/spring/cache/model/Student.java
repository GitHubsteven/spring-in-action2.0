package com.asa.demo.spring.cache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/13
 * @Descrition: student model
 */
@RedisHash("Student")
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
public class Student implements Serializable {
    public enum Gender {
        MALE, FEMALE
    }

    public Student() {
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;
}
