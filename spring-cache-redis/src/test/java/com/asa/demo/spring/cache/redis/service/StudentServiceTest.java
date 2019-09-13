package com.asa.demo.spring.cache.redis.service;

import com.asa.demo.spring.cache.redis.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void save() {
        Student engStudent = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
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