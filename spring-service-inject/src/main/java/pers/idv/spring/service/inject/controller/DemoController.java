package pers.idv.spring.service.inject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.idv.spring.service.inject.demo.DataBean;
import pers.idv.spring.service.inject.service.IService;

import java.util.Map;

/**
 * @version 1.0.0
 * @author: rongbin.xie
 * @date: 2020/4/26
 * @description:
 * @copyright: COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/service-inject")
public class DemoController {
    private final IService<DataBean> iService;
    private final Map<String, IService<?>> serviceMap;

    public DemoController(IService<DataBean> iService, Map<String, IService<?>> serviceMap) {
        this.iService = iService;
        this.serviceMap = serviceMap;
    }

    @GetMapping("/demo/{id}")
    public Object demo(@PathVariable("id") Integer id) {
        return iService.demo();
    }
}
