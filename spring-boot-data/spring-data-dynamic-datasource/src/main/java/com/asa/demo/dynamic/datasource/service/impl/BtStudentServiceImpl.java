package com.asa.demo.dynamic.datasource.service.impl;

import com.asa.demo.dynamic.datasource.mapper.BtStudentMapper;
import com.asa.demo.dynamic.datasource.model.BtStudentModel;
import com.asa.demo.dynamic.datasource.service.BtStudentService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author xrb16
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2022-10-07 14:34:02
 */
@Service
public class BtStudentServiceImpl extends ServiceImpl<BtStudentMapper, BtStudentModel> implements BtStudentService {
    @DS("slave_1")
    public BtStudentModel findStudent(Integer id) {
        return getById(id);
    }
}
