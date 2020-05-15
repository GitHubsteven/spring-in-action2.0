package com.asa.demo.spring.cache.model.red;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition: student model
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
