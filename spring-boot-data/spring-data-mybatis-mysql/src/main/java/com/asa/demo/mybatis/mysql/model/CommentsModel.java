package com.asa.demo.mybatis.mysql.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class CommentsModel extends BaseModel<Integer> {
    private String remark;
    private Integer blogId;
}
