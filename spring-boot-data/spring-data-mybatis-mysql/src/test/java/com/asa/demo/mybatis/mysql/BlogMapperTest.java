package com.asa.demo.mybatis.mysql;

import com.asa.dem.spring.boot.vwe.bean.BlogTreeBean;
import com.asa.demo.mybatis.mysql.mapper.BlogMapper;
import com.asa.demo.mybatis.mysql.model.BlogModel;
import com.asa.demo.mybatis.mysql.model.CountUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 9:53 2019/10/16.
 */
public class BlogMapperTest extends BaseTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void testGetById() {
        BlogModel blog = blogMapper.getById(1);
        System.out.println(blog);
    }

    @Test
    public void testInsertBlog() {
        int result = blogMapper.insertBlog("title_4", "rong.lisa");
        System.out.println(result);
    }

    @Test
    public void testCountUserBlog() {
        List<CountUser> countUsers = blogMapper.listUserBlog();
        countUsers.forEach(System.out::println);
    }

    @Test
    public void testCount() {
        System.out.println(blogMapper.count());
    }

    @Test
    public void testCountByCriteria() {
        BlogModel checkModel = new BlogModel();
        checkModel.setAuthor("asa.x");
        System.out.println(blogMapper.countByCriteria(checkModel));
    }

    @Test
    public void testInsertModel() {
        BlogModel blogModel = new BlogModel();
        blogModel.setTitle("will i get id without option?");
        blogModel.setAuthor("asa.x-test");

        Integer insert = blogMapper.insert(blogModel);
        System.out.println(insert);
    }

    @Test
    public void testBlogTree() {
//        BlogTreeBean blogTree = blogMapper.blogTree(11);
//        System.out.println(blogTree.getBlog());
    }
}
