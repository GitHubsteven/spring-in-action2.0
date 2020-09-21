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

    /**
     * 通过id来更新name
     *
     * @param model 更新信息
     * @return 更新信息
     */
    @Update({"<script>",
            "update Author",
            "  <set>",
            "    <if test='model.author != null'>author=#{model.author}</if>",
            "  </set>",
            "where id=#{model.id}",
            "</script>"})
    int updateName(@Param("model") BlogModel model);
}
