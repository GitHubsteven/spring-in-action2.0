/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.dao;

import com.asa.demo.annotation.DataSourceWith;
import com.asa.demo.config.DataSourceConfigurer;
import com.asa.demo.model.UserModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<UserModel> {

    @DataSourceWith(key = DataSourceConfigurer.MASTER_DATASOURCE)
    @Insert("insert into user(name,age) values(#{name},#{age})")
    Integer createUser(String name, int age);

    @DataSourceWith(key = DataSourceConfigurer.SLAVE_DATASOURCE)
    @Select("select * from user")
    List<UserModel> listUsers();

    @DataSourceWith(key = DataSourceConfigurer.SLAVE_DATASOURCE)
    @Select("select * from user where id = #{id}")
    UserModel getById(int id);

    @Select("select * from user where id = #{id}")
    UserModel getByIdRound(int id);
}
