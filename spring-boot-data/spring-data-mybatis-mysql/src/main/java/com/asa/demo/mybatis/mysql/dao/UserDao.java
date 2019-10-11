package com.asa.demo.mybatis.mysql.dao;

import com.asa.demo.mybatis.mysql.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2019/10/7
 * @Descrition:
 */
@Mapper
public interface UserDao {
    @Insert("INSERT INTO user(name,email) VALUES(#{name},#{email})")
    int insert(@Param("name") String name,
               @Param("email") String email);

    @Select("select * from user")
    List<UserModel> findAll();

    @Select("select * from user where id=#{id}")
    UserModel findById(@Param("id") Integer id);

    /**
     * 计算数量
     *
     * @return 用户数量
     */
    int countUser();

    /**
     * 通过id获取用户
     *
     * @param id 用户id
     */
    UserModel getById(@Param("id") long id);
}
