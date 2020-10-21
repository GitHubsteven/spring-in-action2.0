package com.asa.dem.spring.boot.vwe.model;

import com.asa.dem.spring.boot.common.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/19
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vwe_tags")
public class TagModel extends BaseModel<Integer> {

    private Long commentsId;

    private String name;
}
