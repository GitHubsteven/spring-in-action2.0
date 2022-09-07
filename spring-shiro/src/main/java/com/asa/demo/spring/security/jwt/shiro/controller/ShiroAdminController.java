package com.asa.demo.spring.security.jwt.shiro.controller;

import com.asa.demo.spring.security.jwt.shiro.bean.UserBean;
import com.asa.demo.spring.security.jwt.shiro.response.AuthResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/user")
public class ShiroAdminController {

    @RequestMapping("/business")
    Mono<String> fluxResult() {
        return Mono.defer(() -> Mono.just("result is ready!"));
    }

    @RequestMapping("/authentication")
    public Mono<AuthResponse> authentication(@RequestBody UserBean userBean) {
        final String userName = userBean.getUserName();
        String token = String.format("jwt-token for user[%s]", userName);
        final AuthResponse authResponse = new AuthResponse()
                .setUsername(userName)
                .setRoles(Arrays.asList("admin", "user"))
                .setToken(token)
                .setUserId("001");
        return Mono.defer(() -> Mono.just(authResponse));
    }
}
