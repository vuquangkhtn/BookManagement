package com.hcmus.study.bookmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class BookList implements Serializable {
    private List<Book> books;
    public BookList() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getListBook() {
        return books;
    }

    public int size() {
        return books.size();
    }

    public boolean contain(Book book) {
        return books.contains(book);
    }

    public BookList clone() {
        BookList bookList = new BookList();
        bookList.books = this.books;
        return bookList;
    }
}
