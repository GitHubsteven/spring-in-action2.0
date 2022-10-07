/**
 * @author: asx
 * @date: 2022/9/15
 * @descrition:
 */
package com.asa.demo.dao;

import com.asa.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    UserModel findById(@Param("id") Integer id);
}
