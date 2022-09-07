/**
 * @author: asa.x
 * @date: 2022/9/6
 * @descrition:
 */
package com.asa.demo.controller;

import com.asa.demo.bean.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/master-slave/demo")
public class DemoController {

    @PostMapping("/create")
    public void create() {

    }

    @GetMapping("/get/{id}")
    public UserResponse getUser(@PathVariable("id") Integer id) {
        return new UserResponse();
    }
}
