package com.asa.demo.spring.security.jwt.controller;

import com.asa.demo.spring.security.jwt.bean.DemoRequest;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:29 2019/8/29.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/getJwt")
    public String getJwt(@RequestBody DemoRequest request) {
        return Base64Utils.encodeToUrlSafeString(request.getPassword().getBytes(StandardCharsets.UTF_8));
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}