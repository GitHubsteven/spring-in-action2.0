package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.asa.dem.spring.boot.vwe.service.IBlogService;
import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImplTest extends BaseServiceTest {
    @Autowired
    IBlogService iBlogService;

    @Test
    public void testSaveBlog() {
        BlogModel blog = new BlogModel();
        blog.setAuthor("BlogServiceImplTest")
                .setTitle("testSaveBlog");
        boolean isSaved = iBlogService.save(blog);
        Assert.assertTrue(isSaved);
    }
}