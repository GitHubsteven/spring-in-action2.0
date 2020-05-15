package com.asa.demo.spring.aspect.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 10:20 2019/12/11.
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Book extends AccessBean {
    private String name;
    private String isbn;
}