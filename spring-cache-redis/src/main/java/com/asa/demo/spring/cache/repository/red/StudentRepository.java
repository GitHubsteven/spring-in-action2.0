package com.asa.demo.spring.cache.repository.red;

import com.asa.demo.spring.cache.model.red.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
