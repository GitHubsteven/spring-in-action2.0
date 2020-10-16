package com.asa.demo.spring.mongo.comparison.service.morphia;

import com.asa.demo.spring.mongo.comparison.bean.PageResult;
import com.asa.demo.spring.mongo.comparison.model.Author;
import com.asa.demo.spring.mongo.comparison.model.Book;
import com.asa.demo.spring.mongo.comparison.service.IMongoService;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.Sort;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/10/14
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Service
public class MorphiaServiceImpl implements IMongoService<Book> {
    private final Datastore datastore;


    public MorphiaServiceImpl(MongoClient mongoClient) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.asa.demo.spring.mongo.comparison.model");
        datastore = morphia.createDatastore(mongoClient, "spring-data");
        datastore.ensureIndexes();
    }

    @Override
    public List<Book> listAllCustomers() {
        return datastore.createQuery(Book.class)
                .field("title")
                .contains("Learning Java")
                .asList();
    }

    @Override
    public String create(Book book) {
        datastore.save(book);
        return book.getIsbn();
    }

    @Override
    public Book get(String id) {
        return datastore.createQuery(Book.class)
                .field("isbn")
                .equal("9781565927186")
                .get();
    }

    public void update() {
        Query<Book> query = datastore.createQuery(Book.class)
                .field("title")
                .contains("Learning Java");

        UpdateOperations<Book> updates = datastore.createUpdateOperations(Book.class)
                .inc("price", 1)
                .set("publisher.name", "asa.x");
        datastore.update(query, updates);

    }

    public void delete() {
        Query<Book> query = datastore.createQuery(Book.class)
                .field("title")
                .contains("Learning Java");

        datastore.delete(query);
    }

    public List<Author> aggregate() {
        Iterator<Author> iterator = datastore.createAggregation(Book.class)
                .group("author", Group.grouping("books", Group.push("title")))
                .out(Author.class);
        List<Author> authors = new ArrayList<>();
        while (iterator.hasNext()) {
            authors.add(iterator.next());
        }
        return authors;
    }

    public PageResult<Book> selectPage() {
        long count = datastore.createQuery(Book.class)
                .field("author")
                .equal("Tom Kirkman")
                .count();

        List<Book> books = datastore.createQuery(Book.class)
                .field("author")
                .equal("Tom Kirkman")
                .order(Sort.descending("isbn"))
                .asList(new FindOptions().limit(1).skip(2));
        return new PageResult<>(books, count);
    }

}
