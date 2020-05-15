package com.asa.demo.spring.boot.mysql.repository;

import com.asa.demo.spring.boot.mysql.model.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: asa.x
 * @date: 2019/12/17
 * @descrition:
 */
@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {

}
