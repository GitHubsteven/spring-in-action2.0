package com.asa.demo.mybatis.mysql;

import com.asa.demo.mybatis.mysql.mapper.SessionMapper;
import com.asa.demo.mybatis.mysql.model.SessionModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: 关于sessionMapper的测试
 * @Author jet.xie
 * @Date: Created at 11:23 2019/11/1.
 */
public class SessionTest extends BaseTest {
    @Autowired
    private SessionMapper sessionMapper;

    @Test
    public void testSelectById() {
        SessionModel sessionModel = sessionMapper.selectById(1);
        System.out.println(sessionModel.getRemark());
    }
}