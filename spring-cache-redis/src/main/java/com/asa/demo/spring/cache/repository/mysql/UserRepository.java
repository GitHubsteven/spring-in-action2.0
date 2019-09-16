package com.asa.demo.spring.cache.repository.mysql;

import com.asa.demo.spring.cache.model.mysql.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * @Authoer: asa.x
 * @Date: 2019/9/13
 * @Descrition:
 */
public interface UserRepository extends CrudRepository<UserModel, Integer> {

}
