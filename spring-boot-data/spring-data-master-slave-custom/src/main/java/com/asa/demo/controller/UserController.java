/**
 * @author: asx
 * @date: 2022/9/8
 * @descrition:
 */
package com.asa.demo.controller;

import com.asa.demo.model.UserModel;
import com.asa.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/master/slave/jpa/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get-by-id/{id}")
    public String getById(@PathVariable("id") Integer id) {
        return userService.getById(id).getName();
    }
}
