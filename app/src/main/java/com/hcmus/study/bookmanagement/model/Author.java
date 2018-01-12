package com.hcmus.study.bookmanagement.model;

import java.io.Serializable;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class Author implements Serializable {

    public int handle;
    public static int nextHandle = 0;

    public String name;
    public String birth;
    public String nation;
    public BookList bookList;

    public Author() {
        handle = nextHandle;
        nextHandle++;
    }
}
