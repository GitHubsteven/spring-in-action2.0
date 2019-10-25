package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.CommentsModel;
import com.asa.dem.spring.boot.vwe.mapper.CommentsDao;
import com.asa.dem.spring.boot.vwe.service.ICommentsService;
import com.asa.dem.spring.boot.vwe.service.impl.BaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author asa.x
 * @since 2019-10-25
 */
@Service
public class CommentsServiceImpl extends BaseService<CommentsDao, CommentsModel> implements ICommentsService {

}
