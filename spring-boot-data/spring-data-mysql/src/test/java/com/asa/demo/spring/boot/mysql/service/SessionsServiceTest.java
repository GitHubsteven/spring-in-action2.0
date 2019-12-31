package com.asa.demo.spring.boot.mysql.service;

import com.asa.demo.spring.boot.mysql.model.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SessionsServiceTest extends BaseServiceTest {
    @Autowired
    private SessionsService sessionsService;

    @Test
    public void add() {
        Session session = new Session();
        session.setRemark("test session add")
                .setUserId(1)
                .setSessionId("IJIE_23");

        sessionsService.add(session);
    }
}