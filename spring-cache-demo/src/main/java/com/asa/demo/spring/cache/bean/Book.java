package com.asa.demo.spring.cache.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @date: Created at 17:44 2019/8/27.
 */
@Setter
@Getter
@Accessors(chain = true)
@ToString
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
}