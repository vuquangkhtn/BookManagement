package com.hcmus.study.bookmanagement.model;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class User {
    public Account account;
    public BookList bookList;

    public User(Account account) {
        this.account = account;
        this.bookList = new BookList();
    }
}
