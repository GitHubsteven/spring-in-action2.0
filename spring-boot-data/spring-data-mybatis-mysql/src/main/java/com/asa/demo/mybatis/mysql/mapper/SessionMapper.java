package com.asa.demo.mybatis.mysql.mapper;

import com.asa.demo.mybatis.mysql.model.SessionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:13 2019/11/1.
 */
@Mapper
public interface SessionMapper extends BaseMapper<SessionModel> {
    /**
     * 通过id获取model
     *
     * @param id id
     * @return session信息
     */
    SessionModel selectById(@Param("id") Integer id);
}