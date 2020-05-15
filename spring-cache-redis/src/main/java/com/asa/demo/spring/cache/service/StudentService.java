package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.red.Student;
import com.asa.demo.spring.cache.repository.red.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * @return 保存的id
     */
    public String save(Student student) {
        Student save = studentRepository.save(student);
        return save.getId();
    }

    /**
     * 通过id获取pojo
     *
     * @param id 学生id
     */
    @Cacheable(value = "students", key = "#id")
    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    /**
     * 修改名称
     *
     * @param id   学生id
     * @param name 名称
     */
    public void update(String id, String name) {
        Student foundStudent = findById(id);
        if (foundStudent == null)
            throw new RuntimeException(String.format("student[id:%s]不存在", id));
        foundStudent.setName(name);
        studentRepository.save(foundStudent);
    }

    /**
     * 通过id删除
     *
     * @param id 学生id
     */
    public void delete(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> listAllStudent() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
