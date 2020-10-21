package com.asa.dem.spring.boot.vwe.service.dao;

import com.asa.dem.spring.boot.vwe.bean.BlogTreeBean;
import com.asa.dem.spring.boot.vwe.dao.BlogDao;
import com.asa.dem.spring.boot.vwe.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BlogDaoTest extends BaseServiceTest {
    @Autowired
    private BlogDao blogDao;

    @Test
    public void test() {
        BlogTreeBean result = blogDao.blogTree(11);
        System.out.println(result.getComments());
    }
}
