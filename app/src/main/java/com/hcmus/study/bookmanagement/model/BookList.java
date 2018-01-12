package com.hcmus.study.bookmanagement.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class BookList {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getListBook() {
        return books;
    }
}
