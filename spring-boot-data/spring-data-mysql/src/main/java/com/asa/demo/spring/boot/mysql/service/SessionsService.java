package com.asa.demo.spring.boot.mysql.service;

import com.asa.demo.spring.boot.mysql.model.Session;
import com.asa.demo.spring.boot.mysql.repository.SessionRepository;
import org.springframework.stereotype.Service;

/**
 * @author: asa.x
 * @date: 2019/12/17
 * @descrition:
 */
@Service
public class SessionsService {
    private final SessionRepository sessionRepository;

    public SessionsService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void add(Session session) {
        Session save = sessionRepository.save(session);
    }
}
