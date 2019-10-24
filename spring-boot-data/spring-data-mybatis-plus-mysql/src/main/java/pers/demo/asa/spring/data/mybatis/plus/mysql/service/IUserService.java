package pers.demo.asa.spring.data.mybatis.plus.mysql.service;

import pers.demo.asa.spring.data.mybatis.plus.mysql.model.User;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:33 2019/10/24.
 */
public interface IUserService {
    /**
     * 根据查询条件查询用户
     *
     * @param param 查询参数
     * @return 用户集合
     */
    List<User> listUsers(User param);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 保存的用户数量
     */
    int saveUser(User user);
}