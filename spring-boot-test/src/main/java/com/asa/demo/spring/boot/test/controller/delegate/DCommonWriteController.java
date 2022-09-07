package com.asa.demo.spring.boot.test.controller.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/9/24
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/delegate/common")
public class DCommonWriteController implements IWriteApi {
    private final IWrite iWrite;

    public DCommonWriteController(@Qualifier("writeConductor") IWrite iWrite) {
        this.iWrite = iWrite;
    }

//    @RequestMapping("/write")
    public String write() {
        return iWrite.write();
    }
}
