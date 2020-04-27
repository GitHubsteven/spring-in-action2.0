package pers.idv.spring.service.inject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.idv.spring.service.inject.demo.DataBean;
import pers.idv.spring.service.inject.service.IService;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/26
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/on-condition")
public class OnConditionController {
    @Autowired
    private IService<DataBean> iService;

    @GetMapping("/demo")
    public Object demo() {
        return iService.demo();
    }
}
