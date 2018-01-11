package com.hcmus.study.bookmanagement.model;

import com.hcmus.study.bookmanagement.model.Author;

import java.util.LinkedHashMap;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class AuthorManager {
    public static LinkedHashMap<Integer, Author> list = new LinkedHashMap<>();

    public static void registerObject(Author serverObj) {
        list.put(serverObj.handle, serverObj);
    }
    public static void unRegisterObject(Author serverObj) {
        list.remove(serverObj.handle);
    }

    public static Author findObject(int handle){
        return list.get(handle);
    }
}
