package pers.asa.demo.spring.multi.database.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pers.asa.demo.spring.multi.database.model.account.UserModel;
import pers.asa.demo.spring.multi.database.model.oms.TradeModel;
import pers.asa.demo.spring.multi.database.repository.account.UserRepository;
import pers.asa.demo.spring.multi.database.repository.oms.OrderRepository;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class JpaMultiDataSourceServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional(value = "userTransactionManager", rollbackFor = Exception.class)
    public void whenCreatingUser_thenCreated() {
        UserModel UserModel = new UserModel();
        UserModel.setUsername("John");
        UserModel.setCountry("CN");
        UserModel.setGeneration(1);
        UserModel.setAge(20);
        UserModel = userRepository.save(UserModel);
        final UserModel one = userRepository.findById(UserModel.getId()).orElse(null);
        assertNotNull(one);
    }

    @Test
//    @Transactional("userTransactionManager")
    public void whenCreatingUsersWithSameEmail_thenRollback() {
        UserModel user1 = new UserModel();
        user1.setUsername("John");
        user1.setGeneration(1);
        user1.setCountry("CN");
        user1.setAge(20);
        user1 = userRepository.save(user1);
        assertNotNull(userRepository.findById(user1.getId()).get());

        UserModel user2 = new UserModel();
        user2.setUsername("John");
        user2.setCountry("EN");
        user2.setGeneration(1);
        user2.setAge(10);
        user2 = userRepository.save(user2);

        assertNull(userRepository.findById(user2.getId()).get());
    }


    @Test
    public void createUserAndOrder() {
        UserModel user1 = new UserModel();
        user1.setUsername("John.snow");
        user1.setGeneration(1);
        user1.setCountry("CN");
        user1.setAge(20);
        user1 = userRepository.save(user1);
        assertNotNull(userRepository.findById(user1.getId()).get());

        TradeModel order = new TradeModel();
        order.setAmount(new BigDecimal("12.3"));
        order.setOrderId("001");

        order = orderRepository.save(order);
    }


    @Test
    @Transactional(value = "omsTransactionManager", rollbackFor = Exception.class)
    public void createOrderAndThenRollback(){
        TradeModel order = new TradeModel();
        final Random random = new Random();
        order.setOrderId("order"+ random.nextInt(100));
        order.setAmount(new BigDecimal("12.3"));
        order = orderRepository.save(order);
        final TradeModel order1 = orderRepository.findById(order.getId()).orElse(null);
        assertNotNull(order1);
    }
}