package com.asa.demo.spring.mongo.comparison.service.morphia;

import com.asa.demo.spring.mongo.comparison.BaseTest;
import com.asa.demo.spring.mongo.comparison.bean.PageResult;
import com.asa.demo.spring.mongo.comparison.model.Author;
import com.asa.demo.spring.mongo.comparison.model.Book;
import com.asa.demo.spring.mongo.comparison.model.Publisher;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MorphiaServiceImplTest extends BaseTest {
    @Autowired
    private MorphiaServiceImpl morphiaService;

    @Test
    public void listAllCustomers() {
        List<Book> books = morphiaService.listAllCustomers();
        books.forEach(System.out::println);
    }

    @Test
    public void create() {
        Publisher publisher = new Publisher(new ObjectId(), "Awsome Publisher");
        Book book = new Book("9781565927186", "Learning Java", "Tom Kirkman", 3.95, publisher);
        Book companionBook = new Book("9789332575103", "Java Performance Companion",
                "Tom Kirkman", 1.95, publisher);
        book.addCompanionBooks(companionBook);

        morphiaService.create(companionBook);

        morphiaService.create(book);
    }


    @Test
    public void create2() {
        Publisher publisher = new Publisher(new ObjectId(), "Awsome Publisher");
        Book book = new Book("9781565927186", "Learning Java", "Tom Kirkman", 3.95, publisher);
        book.setIsbn(null);
        morphiaService.create(book);
        System.out.println(book.getIsbn());
    }

    @Test
    public void get() {
        Book book = morphiaService.get("9789332575103");
        Assert.assertEquals(1, book.getCompanionBooks().size());
    }

    @Test
    public void testAggregate() {
        List<Author> authors = morphiaService.aggregate();
        for (Author author : authors) {
            System.out.println(author.getName());
        }
    }

    @Test
    public void testUpdate() {
        morphiaService.update();
    }

    @Test
    public void testSelectPage() {
        PageResult<Book> pageResult = morphiaService.selectPage();
        System.out.println(pageResult.getRecords().size());
    }
}