/**
 * @author: asx
 * @date: 2022/9/17
 * @descrition:
 */
package com.asa.demo.sharding.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/master/slave/sharding/student")
public class StudentController {

    @GetMapping("/student/{id}")
    public String getById(@PathVariable("id") Integer id) {
        return "";
    }
}
