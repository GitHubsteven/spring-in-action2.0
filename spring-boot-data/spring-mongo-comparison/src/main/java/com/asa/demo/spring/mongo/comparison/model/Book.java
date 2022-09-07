package com.asa.demo.spring.mongo.comparison.model;

import lombok.*;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/16
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity("Books")
@ToString
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    @Property("price")
    private double cost;

    @Embedded
    private Publisher publisher;
    @Reference
    private List<Book> companionBooks = new ArrayList<>(0);

    public Book(String isbn, String title, String author, double cost, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.publisher = publisher;
    }

    public void addCompanionBooks(Book book) {
        this.companionBooks.add(book);
    }
}
