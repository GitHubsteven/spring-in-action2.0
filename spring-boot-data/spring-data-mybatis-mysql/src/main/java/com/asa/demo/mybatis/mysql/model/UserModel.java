package com.asa.demo.mybatis.mysql.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Authoer: asa.x
 * @Date: 2019/10/7
 * @Descrition:
 */
@Setter
@Getter
public class UserModel extends BaseModel<Long> {
    private String name;
    private String password;
    private String email;
    private String role;

}
