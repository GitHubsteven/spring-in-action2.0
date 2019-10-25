package com.asa.dem.spring.boot.vwe.service.impl;

import com.asa.dem.spring.boot.vwe.model.UserModel;
import com.asa.dem.spring.boot.vwe.mapper.UserDao;
import com.asa.dem.spring.boot.vwe.service.IUserService;
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
public class UserServiceImpl extends BaseService<UserDao, UserModel> implements IUserService {

}
