package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.asa.dem.spring.boot.vwe.dao.BlogMapper;
import com.asa.dem.spring.boot.vwe.service.IBlogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author asa.x
 * @since 2019-10-31
 */
@Service
public class BlogServiceImpl extends BaseService<BlogMapper, BlogModel> implements IBlogService {

}
