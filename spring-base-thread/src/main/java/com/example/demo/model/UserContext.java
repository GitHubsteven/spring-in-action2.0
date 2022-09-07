package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:24 2018/11/1.
 */
@Setter
@Getter
public class UserContext {
    UserContext subUser;
    private String name = "default";
}