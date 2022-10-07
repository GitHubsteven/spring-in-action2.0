package com.asa.demo.dynamic.datasource.mapper;

import com.asa.demo.dynamic.datasource.model.BtStudentModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author xrb16
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2022-10-07 14:34:02
 * @Entity com/asa/demo/dynamic/datasource.domain.BtStudentModel
 */
public interface BtStudentMapper extends BaseMapper<BtStudentModel> {

    int count();
}
