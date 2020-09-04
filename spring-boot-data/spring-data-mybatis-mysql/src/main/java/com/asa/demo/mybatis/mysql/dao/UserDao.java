package com.asa.demo.mybatis.mysql.dao;

import com.asa.demo.mybatis.mysql.model.BlogModel;
import com.asa.demo.mybatis.mysql.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: asa.x
 * @date: 2019/10/7
 * @descrition:
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


    @Update({"<script>",
            "update user",
            "   <set>",
            "       <if test='model.title !=null'> title like #{model.title}",
            "</script"})
    int updateNames(@Param("model") BlogModel model);
}
