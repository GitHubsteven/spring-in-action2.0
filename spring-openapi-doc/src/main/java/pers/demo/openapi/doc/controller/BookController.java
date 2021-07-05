package pers.demo.openapi.doc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.demo.openapi.doc.bean.Book;

import java.util.Collection;
import java.util.Collections;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/5 14:19
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/5 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/api/book")
public class BookController {
    @GetMapping("/")
    public Collection<Book> findBooks() {
        return Collections.emptyList();
    }
}

