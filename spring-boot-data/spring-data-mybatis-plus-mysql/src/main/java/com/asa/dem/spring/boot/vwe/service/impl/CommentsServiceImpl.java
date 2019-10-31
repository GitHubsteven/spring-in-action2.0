package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.CommentsModel;
import com.asa.dem.spring.boot.vwe.dao.CommentsMapper;
import com.asa.dem.spring.boot.vwe.service.ICommentsService;
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
public class CommentsServiceImpl extends BaseService<CommentsMapper, CommentsModel> implements ICommentsService {

}
