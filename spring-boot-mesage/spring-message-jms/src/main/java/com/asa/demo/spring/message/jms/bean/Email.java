package com.asa.demo.spring.message.jms.bean;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/9/22
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@Accessors(chain = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String to;
    private String body;
}
