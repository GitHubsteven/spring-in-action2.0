package pers.asa.demo.spring.service.center.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.asa.demo.spring.service.center.BaseTest;

public class SyncTaskServiceTest extends BaseTest {
    @Autowired
    private SyncTaskService syncTaskService;

    @Test
    public void doSync() {
        syncTaskService.doSync();
    }
}