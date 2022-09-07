package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 文本内容
 * @Date: Created at 16:03 2018/11/1.
 */
@Setter
@Getter
public class ContextMessage implements Serializable {
    private String serviceAddress;
    private String controllerAddr;
    private String threadName;
    private Object requestParams;
}