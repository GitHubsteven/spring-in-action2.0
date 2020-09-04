package com.asa.dem.spring.boot.vwe.bean;

import com.asa.dem.spring.boot.vwe.model.BlogModel;
import com.asa.dem.spring.boot.vwe.model.CommentsModel;
import com.asa.dem.spring.boot.vwe.model.UserModel;
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
public class BlogTreeBean {
    private BlogModel blog;
    private UserModel user;
    private Set<CommentsModel> comments;
}
