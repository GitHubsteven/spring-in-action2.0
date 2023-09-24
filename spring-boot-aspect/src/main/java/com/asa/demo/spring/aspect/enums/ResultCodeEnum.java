package com.asa.demo.spring.aspect.enums;

import lombok.Data;

/**
 * @author: rongbin.xie
 * @email: xierongbin@chinalife-p.com.cn
 * @date: 2023/9/24
 */
public enum ResultCodeEnum {

    SUCCESS(200, "success"),
    FAIL(404, "fail");;

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
