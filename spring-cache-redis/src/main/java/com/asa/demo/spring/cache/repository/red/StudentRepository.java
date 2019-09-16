package com.asa.demo.spring.cache.repository.red;

import com.asa.demo.spring.cache.model.red.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/13
 * @Descrition:
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
