package com.asa.demo.spring.aspect.controller;

import com.asa.demo.spring.aspect.bean.UserContextThreadLocal;
import com.asa.demo.spring.aspect.core.Loggable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:38 2019/9/20.
 */
@RestController
@RequestMapping("/book")
public class BookController implements Loggable {
    @RequestMapping("/getBookByIsb/{isb}")
    public String getBookByISB(@PathVariable("isb") String isb) {
        LOGGER.info("---------->>>>>>>>>getBookByISB");
        return UserContextThreadLocal.get().getLoginName() + "book" + isb;
    }
}