package com.baomidou.ant.vwe.service.impl;

import com.baomidou.ant.vwe.entity.Blog;
import com.baomidou.ant.vwe.mapper.BlogMapper;
import com.baomidou.ant.vwe.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author asa.x
 * @since 2019-10-24
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
