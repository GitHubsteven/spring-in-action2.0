package com.asa.dem.spring.boot.vwe.dao;

import com.asa.dem.spring.boot.vwe.model.UserModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author asa.x
 * @since 2019-11-06
 */
@Repository
public interface UserDao extends BaseMapper<UserModel> {

}
