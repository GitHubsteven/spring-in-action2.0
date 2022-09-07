package com.asa.demo.mybatis.mysql.bean;

import com.asa.demo.mybatis.mysql.model.BlogModel;
import com.asa.demo.mybatis.mysql.model.CommentsModel;
import com.asa.demo.mybatis.mysql.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/31
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
public class BlogDraft {
    private BlogModel blog;
    private UserModel author;
    private Set<CommentsModel> comments;
}
