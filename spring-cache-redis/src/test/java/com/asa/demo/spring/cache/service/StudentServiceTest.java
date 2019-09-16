package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.red.Student;
import junit.runner.BaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}