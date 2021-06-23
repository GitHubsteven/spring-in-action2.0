package pers.asa.demo.spring.boot.base.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.asa.demo.spring.boot.base.util.ApplicationContextUtil;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestServiceTest {

    @Test
    public void test1() {
        final TestService testService = ApplicationContextUtil.getBean(TestService.class);
        testService.test();
    }
}