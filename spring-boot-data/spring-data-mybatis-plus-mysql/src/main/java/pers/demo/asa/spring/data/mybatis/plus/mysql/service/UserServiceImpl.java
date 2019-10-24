package pers.demo.asa.spring.data.mybatis.plus.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.demo.asa.spring.data.mybatis.plus.mysql.mapper.UserMapper;
import pers.demo.asa.spring.data.mybatis.plus.mysql.model.User;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:33 2019/10/24.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers(User param) {
        if (param == null) {
            return userMapper.selectList(null);
        }
        throw new IllegalArgumentException("主人还不会!");
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }
}