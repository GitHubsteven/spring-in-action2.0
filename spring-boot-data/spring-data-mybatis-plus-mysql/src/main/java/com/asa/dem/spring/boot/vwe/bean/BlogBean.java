package com.asa.dem.spring.boot.vwe.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 18:40 2019/10/31.
 */
@Setter
@Getter
public class BlogBean implements Serializable {
    private String title;

    private String author;
}