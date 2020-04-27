package pers.idv.spring.service.inject.demo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/26
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@JsonSerialize
@AllArgsConstructor
public class AdjBean {
    private String dep;
    private String id;
}
