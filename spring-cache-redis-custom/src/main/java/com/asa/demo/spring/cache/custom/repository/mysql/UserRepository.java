package com.asa.demo.spring.cache.custom.repository.mysql;

import com.asa.demo.spring.cache.custom.model.mysql.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: asa.x
 * @date: 2019/9/13
 * @descrition:
 */
public interface UserRepository extends CrudRepository<UserModel, Integer> {

}
