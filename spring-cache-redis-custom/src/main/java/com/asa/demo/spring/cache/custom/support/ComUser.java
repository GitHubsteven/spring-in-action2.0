package com.asa.demo.spring.cache.custom.support;

import com.asa.demo.spring.cache.custom.model.mysql.UserModel;
import com.asa.demo.spring.cache.custom.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author: asa.x
 * @date: 2019/9/15
 * @descrition:
 */
@Component
public class ComUser implements Loggable {

    private final UserRepository userRepository;

    @Autowired
    public ComUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(cacheNames = "users", keyGenerator = "userKeyGenerator", unless = "#result ==null")
    public UserModel getUserById(Integer id) {
        logger.info("--------->load user info from mysql");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error("--------->thread sleep for 1s failed!");
        }
        return userRepository.findById(id).orElse(null);
    }

    @CachePut(cacheNames = "users", keyGenerator = "userKeyGenerator")
    public UserModel updateModel(Integer id, String email, String name) {
        UserModel saved = userRepository.findById(id).orElse(null);
        if (saved == null) throw new RuntimeException(String.format("user(id:%s) not existed", id));
        saved.setName(name);
        saved.setEmail(email);
        return saved;
    }

    @CacheEvict(cacheNames = "users", keyGenerator = "userKeyGenerator")
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
