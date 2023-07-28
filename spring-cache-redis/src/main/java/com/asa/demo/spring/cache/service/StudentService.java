package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.red.Student;
import com.asa.demo.spring.cache.repository.red.StudentRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

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

    public void saveAndDelete() {
        Student student = new Student();
        student.setName("transaction-test");
        student.setGender(Student.Gender.MALE);
        student.setGrade(123);
        saveAndDelete(student);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveAndDelete(Student student) {
        studentRepository.save(student);
        String id = student.getId();
        if (id != null) {
            throw new RuntimeException("transaction test!");
        }
        studentRepository.deleteById(id);
    }
}
