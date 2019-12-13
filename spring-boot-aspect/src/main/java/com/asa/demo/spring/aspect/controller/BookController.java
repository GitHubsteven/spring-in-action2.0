package com.asa.demo.spring.aspect.controller;

import com.asa.demo.spring.aspect.bean.Book;
import com.asa.demo.spring.aspect.bean.UserContextThreadLocal;
import com.asa.demo.spring.aspect.core.Loggable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        return UserContextThreadLocal.get().getLoginName() + "book/" + isb;
    }

    @PostMapping("/add")
    public String getInv(@RequestBody Book book, HttpServletRequest servletRequest) {
        System.out.println("---------->" + book.toString());
        String requestBody = (String) servletRequest.getAttribute("request_body");
        System.out.println(requestBody);
        throwExp();
        return requestBody;
    }

    private void throwExp() {
        throw new RuntimeException("test for the servlet filter");
    }
}