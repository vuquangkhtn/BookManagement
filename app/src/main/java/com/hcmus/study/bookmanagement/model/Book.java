package com.hcmus.study.bookmanagement.model;

import com.hcmus.study.bookmanagement.utils.TopicFactory;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class Book {
    public String id;
    public String name;
    public String title;
    public String image;
    public String publicYear;
    public Topic topic;
    public Author author;
    public Publisher publisher;

    public Book getClone() {
        return new Book();
    }
}

