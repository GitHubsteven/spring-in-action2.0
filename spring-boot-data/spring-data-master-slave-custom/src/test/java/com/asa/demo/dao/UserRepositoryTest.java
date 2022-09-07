/**
 * @author: asa.x
 * @date: 2022/9/8
 * @descrition:
 */
package com.asa.demo.dao;

import com.asa.demo.JpaMSApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends JpaMSApplicationTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSelectById() {
        userRepository.findAll().forEach(user -> System.out.println(user.getName()));
    }
}
