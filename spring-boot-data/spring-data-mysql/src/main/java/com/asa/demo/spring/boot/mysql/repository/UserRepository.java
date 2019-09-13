package com.asa.demo.spring.boot.mysql.repository;

import com.asa.demo.spring.boot.mysql.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/13
 * @Descrition:
 */
public interface UserRepository extends CrudRepository<User, String> {

}
