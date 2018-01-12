package com.hcmus.study.bookmanagement.model;

import com.hcmus.study.bookmanagement.utils.TopicFactory;

import java.io.Serializable;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class Book implements Serializable{
    public String id;
    public String name;
    public String publicYear;
    public String content;
    public Topic topic;

    public boolean isFavor;

    public Book getClone() {
        return new Book();
    }
}

