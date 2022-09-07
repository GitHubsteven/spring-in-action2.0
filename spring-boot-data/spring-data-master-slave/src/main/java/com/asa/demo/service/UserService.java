/**
 * @author: asa.x
 * @date: 2022/9/7
 * @descrition:
 */
package com.asa.demo.service;

import com.asa.demo.annotation.DataSourceWith;
import com.asa.demo.config.DataSourceConfigurer;
import com.asa.demo.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService {

    @DataSourceWith(key = DataSourceConfigurer.SLAVE_DATASOURCE)
    public List<UserModel> listUsers() {
        logger.debug("获取部门树数据");
        List<UserModel> deptList = new ArrayList<>();
        return deptList;
    }
}
