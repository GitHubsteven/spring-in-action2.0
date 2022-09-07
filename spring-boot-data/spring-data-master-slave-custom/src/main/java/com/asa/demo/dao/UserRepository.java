/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.dao;

import com.asa.demo.model.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<UserModel, Integer> {

//    @Insert("insert into user(name,age) values(#{name},#{age})")
//    Integer createUser(String name, int age);
//
//    @Select("select * from user")
//    List<UserModel> listUsers();
//
//    @Select("select * from user where id = #{id}")
//    UserModel getById(int id);
//
//    @Select("select * from user where id = #{id}")
//    UserModel getByIdRound(int id);

}
