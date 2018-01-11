package com.hcmus.study.bookmanagement.model;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class Author {

    public int handle;
    public static int nextHandle = 0;

    public String name;
    public String birth;
    public BookList bookList;

    public Author() {
        handle = nextHandle;
        nextHandle++;
    }
}
