package com.asa.demo.spring.session.redis.controller;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/6/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/session")
public class DemoController {
    private static Map<String, Pair<String, String>> sid2UserInfo = new ConcurrentHashMap<>();


    @PostMapping("/set-session")
    public void setSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final boolean isLigalUser = ("admin".equals(username) && "123456".equals(password))
                || ("test".equals(username) && "123456".equals(password));
        if (isLigalUser) {
            // create a cookie
            final String sessionId = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("sid", sessionId);
            sid2UserInfo.put(sessionId, Pair.of("admin", "123456"));
            //add cookie to response
            response.addCookie(cookie);
            response.getWriter().write("set session successfully");
        } else {
            response.setStatus(401);
            response.getWriter().write("unauthenrizated!");
        }
    }

    @PostMapping("/get-session")
    public void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.setStatus(401);
            response.getWriter().write("unauthenrizated");
        } else {
            final String sid = Stream.of(cookies).filter(it -> "sid".equalsIgnoreCase(it.getName()))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
            final Pair<String, String> userInfo = sid2UserInfo.get(sid);
            if (userInfo == null) {
                response.setStatus(401);
                response.getWriter().write("unauthenrizated");
            } else {
                response.setStatus(200);
                response.getWriter().write(userInfo.getFirst() + userInfo.getSecond());
            }
        }
    }
}
