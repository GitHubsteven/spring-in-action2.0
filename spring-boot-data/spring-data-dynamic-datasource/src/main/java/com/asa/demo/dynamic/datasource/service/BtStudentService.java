package com.asa.demo.dynamic.datasource.service;


import com.asa.demo.dynamic.datasource.model.BtStudentModel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xrb16
 * @description 针对表【student】的数据库操作Service
 * @createDate 2022-10-07 14:34:02
 */
public interface BtStudentService extends IService<BtStudentModel> {
    /**
     * 通过id查询学生信息
     *
     * @param id id
     * @return 学生信息
     */
    BtStudentModel findStudent(Integer id);
}
