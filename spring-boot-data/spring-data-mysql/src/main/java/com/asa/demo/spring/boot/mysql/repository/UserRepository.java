package com.asa.demo.spring.boot.mysql.repository;

import com.asa.demo.spring.boot.mysql.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
public interface UserRepository extends CrudRepository<User, String> {

}
