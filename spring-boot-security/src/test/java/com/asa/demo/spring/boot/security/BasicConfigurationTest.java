package com.asa.demo.spring.boot.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author: asaland
 * @date: 2019/8/31
 * @time: 14:25
 * @version: 1.0.0
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicConfigurationTest {
    private TestRestTemplate testRestTemplate;
    URL base;
    @LocalServerPort
    int port;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Before
    public void setUp() throws MalformedURLException {
        testRestTemplate = new TestRestTemplate("asa.x", "123456");
        base = new URL("http://localhost:" + port + "/security/hi");
    }

    @Test
    public void requestShouldNeedAuthentication() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(base.toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("security"));
    }

    @Test
    public void whenUserWithWrongCredentials_thenUnauthorizedPage()
            throws Exception {

        testRestTemplate = new TestRestTemplate("asa.x", "123");
        ResponseEntity<String> response
                = testRestTemplate.getForEntity(base.toString(), String.class);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertTrue(StringUtils.isEmpty(response.getBody()));
    }
}
