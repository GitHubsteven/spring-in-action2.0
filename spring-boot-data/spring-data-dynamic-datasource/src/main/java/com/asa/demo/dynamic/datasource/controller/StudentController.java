/**
 * @author: asx
 * @date: 2022/10/7
 * @descrition:
 */
package com.asa.demo.dynamic.datasource.controller;

import com.asa.demo.dynamic.datasource.model.BtStudentModel;
import com.asa.demo.dynamic.datasource.service.BtStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/dyn-data/student")
public class StudentController {
    private final BtStudentService studentService;

    public StudentController(BtStudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/get-by-id/{id}")
    public String getNameById(@PathVariable Integer id) {
        BtStudentModel student = studentService.findStudent(id);
        return student == null ? null : student.getCode();
    }
}
