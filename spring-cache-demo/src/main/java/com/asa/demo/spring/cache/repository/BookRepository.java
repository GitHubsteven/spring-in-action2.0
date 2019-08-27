package com.asa.demo.spring.cache.repository;

import com.asa.demo.spring.cache.bean.Book;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:48 2019/8/27.
 */
public interface BookRepository {
    /**
     * get the book by isbn
     *
     * @param isbn isbn number
     * @return book info
     */
    Book getByIsbn(String isbn);
}