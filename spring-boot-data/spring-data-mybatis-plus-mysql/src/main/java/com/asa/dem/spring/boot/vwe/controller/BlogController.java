package com.asa.dem.spring.boot.vwe.controller;


import com.asa.dem.spring.boot.vwe.bean.BlogBean;
import com.asa.dem.spring.boot.vwe.dao.BlogMapper;
import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.asa.dem.spring.boot.vwe.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author asa.x
 * @since 2019-10-25
 */
@RestController
@RequestMapping("/vwe/blog")
public class BlogController extends BaseController {
    @Autowired
    private IBlogService iBlogService;

    @RequestMapping("/add")
    public Boolean addBlog(@RequestBody BlogBean blog) {
        BlogModel model = new BlogModel();
        BeanUtils.copyProperties(blog, model);
        return iBlogService.save(model);
    }
}
