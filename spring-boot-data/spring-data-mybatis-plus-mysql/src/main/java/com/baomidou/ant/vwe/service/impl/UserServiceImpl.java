package com.baomidou.ant.vwe.service.impl;

import com.baomidou.ant.vwe.entity.User;
import com.baomidou.ant.vwe.mapper.UserMapper;
import com.baomidou.ant.vwe.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
