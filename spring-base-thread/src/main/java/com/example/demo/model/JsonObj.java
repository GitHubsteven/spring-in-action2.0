package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:53 2018/11/1.
 */
@Setter
@Getter
public class JsonObj {
    private ContextMessage context;
    private Object data;
    private String result;
    private String message;

    public JsonObj(Object data) {
        this.data = data;
    }
}