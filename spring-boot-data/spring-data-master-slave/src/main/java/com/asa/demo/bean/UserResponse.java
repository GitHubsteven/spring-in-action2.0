/**
 * @author: asa.x
 * @date: 2022/9/6
 * @descrition:
 */
package com.asa.demo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserResponse {
    private String username;
    private Integer age;
}
