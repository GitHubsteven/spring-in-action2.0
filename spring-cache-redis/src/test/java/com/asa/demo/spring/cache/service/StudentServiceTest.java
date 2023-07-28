package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.red.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceTest extends BaseServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void save() {
        Student engStudent = new Student(
                "Eng2015003", "xavi alonso", Student.Gender.MALE, 1);
        studentService.save(engStudent);
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void listAllStudent() {
    }

    @Test
    public void selectAndDelete() {
        studentService.saveAndDelete();
    }
}