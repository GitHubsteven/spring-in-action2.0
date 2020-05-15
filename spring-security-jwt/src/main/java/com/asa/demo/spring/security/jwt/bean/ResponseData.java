package com.asa.demo.spring.security.jwt.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 15:08 2019/8/9.
 */
@Setter
@Getter
public class ResponseData {
    private Boolean status = true;
    private Integer code = 200;
    private String message;
    private Object data;
}