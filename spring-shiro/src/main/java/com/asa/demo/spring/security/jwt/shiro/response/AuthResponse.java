package com.asa.demo.spring.security.jwt.shiro.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/24
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@Accessors(chain = true)
public class AuthResponse {
    private String username;
    private String userId;
    private String token;
    private List<String> roles;
}
