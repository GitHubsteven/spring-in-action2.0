/**
 * @author: asx
 * @date: 2023/7/14
 * @descrition:
 */
package com.asa.demo.spring.cache.service;

import com.asa.demo.spring.cache.model.mysql.UserModel;
import com.asa.demo.spring.cache.model.red.Student;
import com.asa.demo.spring.cache.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: asx
 * @date: 2023/7/14
 * @descrition:
 */
@Service
public class UserService {
    ExecutorService executorService = Executors.newFixedThreadPool(4, Executors.defaultThreadFactory());

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveAndDelete() {
        UserModel user = getUserModel();
        saveAndDelete(user);

        executorService.submit(() -> {

        });
    }

    public static UserModel getUserModel() {
        UserModel user = new UserModel();
        int id = ThreadLocalRandom.current().nextInt();
        user.setName("transaction-test-" + id);
        user.setEmail(String.format("xxx%d@xx.com", id));
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveAndDelete(UserModel user) {
        userRepository.save(user);
        Integer id = user.getId();
        if (id != null) {
            throw new RuntimeException("transaction test!");
        }
        userRepository.deleteById(id);
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveAndDelete3(UserModel user) {
        // 当前事务是保持的
        userRepository.save(user);
        Integer id = user.getId();
        removeById(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void removeById(Integer id) {
        // 新的事务失败，那么就可能不成功
        if (id != null) {
            throw new RuntimeException("transaction test!");
        }
        userRepository.deleteById(id);
    }
}
