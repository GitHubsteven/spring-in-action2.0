package com.asa.demo.spring.aspect.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 14:22 2019/12/11.
 */
@Setter
@Getter
@Accessors(chain = true)
public class AccessBean implements Serializable {
    private String token;
    private String clientId;
}