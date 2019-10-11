package com.asa.demo.mybatis.mysql.dao;

import com.asa.demo.mybatis.mysql.model.UserModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:55 2019/10/11.
 */
@Component
public class UserDao {
    private SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 因为缺少某些配置，暂时是运行不了的
     *
     * @param id userId
     * @return user
     */
    public UserModel selectUserById(Long id) {
        return sqlSession.selectOne("selectUserById", id);
    }
}