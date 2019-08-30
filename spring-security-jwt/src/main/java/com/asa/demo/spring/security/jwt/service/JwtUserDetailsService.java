package com.asa.demo.spring.security.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:09 2019/8/30.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) {
        Map<String, UserDetails> users = new ConcurrentHashMap<>();
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        users.put("admin", User.withUsername("admin")
                .password(pwdEncoder.encode("admin123"))
                .roles("admin")
                .build());
        users.put("user1", User.withUsername("user1")
                .password(pwdEncoder.encode("123456"))
                .roles("user")
                .build());
        users.put("asa.x", User.withUsername("asa.x")
                .password(pwdEncoder.encode("123456"))
                .roles("user")
                .build());
        return users.get(username);
    }
}