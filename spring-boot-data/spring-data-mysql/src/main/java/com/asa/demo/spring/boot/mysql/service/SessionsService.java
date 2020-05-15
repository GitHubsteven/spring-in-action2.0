package com.asa.demo.spring.boot.mysql.service;

import com.asa.demo.spring.boot.mysql.model.Session;
import com.asa.demo.spring.boot.mysql.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: asa.x
 * @date: 2019/12/17
 * @descrition:
 */
@Service
public class SessionsService {
    @Autowired
    private SessionRepository sessionRepository;

    public void add(Session session) {
        Session save = sessionRepository.save(session);
    }
}
