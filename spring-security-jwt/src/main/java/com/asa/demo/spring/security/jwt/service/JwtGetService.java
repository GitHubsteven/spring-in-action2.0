package com.asa.demo.spring.security.jwt.service;

import com.asa.demo.spring.security.jwt.bean.DemoRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:36 2019/8/29.
 */
@Service
public class JwtGetService {
    public static final ConcurrentHashMap<String, String> userMap = new ConcurrentHashMap<>();

    static {
        userMap.put("admin", "admin123");
        userMap.put("guess", "123456");
    }


    /**
     * 验证username + password
     *
     * @param request 请求信息
     * @return 是否存在
     */
    public boolean valid(DemoRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new IllegalStateException(String.format("username(%s)或者password(%s)不能为空", username, password));
        }
        String pwd = userMap.get(username);
        if (Objects.equals(pwd, password))
            throw new IllegalArgumentException(String.format("username(%s)或者password(%s)不匹配", username, password));
        return true;
    }

}