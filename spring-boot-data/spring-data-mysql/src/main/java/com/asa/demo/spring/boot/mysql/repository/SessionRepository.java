package com.asa.demo.spring.boot.mysql.repository;

import com.asa.demo.spring.boot.mysql.model.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Authoer: asa.x
 * @Date: 2019/12/17
 * @Descrition:
 */
@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {

}
