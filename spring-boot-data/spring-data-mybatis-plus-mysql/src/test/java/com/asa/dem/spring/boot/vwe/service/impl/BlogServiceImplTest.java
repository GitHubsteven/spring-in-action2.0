package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.asa.dem.spring.boot.vwe.service.IBlogService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlogServiceImplTest extends BaseServiceTest {
    @Autowired
    IBlogService iBlogService;

    @Test
    public void testSaveBlog() {
        BlogModel blog = new BlogModel();
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        blog.setAuthor("BlogServiceImplTest")
                .setTitle("testSaveBlog" + date);
        boolean isSaved = iBlogService.save(blog);
        Assert.assertTrue(isSaved);
    }
}