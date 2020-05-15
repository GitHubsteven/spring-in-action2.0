package com.asa.demo.spring.cache.custom.repository.red;

import com.asa.demo.spring.cache.custom.model.redis.Student;
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
