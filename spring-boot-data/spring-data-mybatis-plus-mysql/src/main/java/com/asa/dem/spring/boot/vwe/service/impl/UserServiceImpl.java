package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.UserModel;
import com.asa.dem.spring.boot.vwe.dao.UserMapper;
import com.asa.dem.spring.boot.vwe.service.IUserService;
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
public class UserServiceImpl extends BaseService<UserMapper, UserModel> implements IUserService {

}
