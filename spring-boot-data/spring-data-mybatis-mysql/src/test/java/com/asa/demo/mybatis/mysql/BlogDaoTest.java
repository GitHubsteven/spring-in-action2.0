package com.asa.demo.mybatis.mysql;

import com.asa.dem.spring.boot.vwe.bean.BlogTreeBean;
import com.asa.demo.mybatis.mysql.dao.BlogDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BlogDaoTest extends BaseTest {
    @Autowired
    private BlogDao blogDao;

    @Test
    public void test() {
        List<BlogTreeBean> result = blogDao.getBlogDetail(Arrays.asList(11, 13));
        System.out.println(result.size());
    }

    @Test
    public void getByEmbededSelect() {
        List<BlogTreeBean> result = blogDao.getBlogDetailSelect(Arrays.asList(11, 13));
        System.out.println(result.size());
    }
}
