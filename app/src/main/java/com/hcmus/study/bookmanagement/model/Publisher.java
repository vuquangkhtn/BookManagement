package com.hcmus.study.bookmanagement.model;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */


/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public class Publisher {
    public String name;
    public BookList bookList;

    public String getField(FieldStrategy fieldStrategy) {
        return fieldStrategy.getField();
    }


    abstract class FieldStrategy {
        public String publisherName;
        public FieldStrategy(String name) {
            this.publisherName = name;
        }
        public abstract String getField();
    }

    class SocialFieldStrategy extends FieldStrategy{
        public SocialFieldStrategy(String name) {
            super(name);
        }

        @Override
        public String getField() {
            String des = " is a \"work of fiction in which a prevailing social problem, such as gender, race, or class prejudice, is dramatized through its effect on the characters of a novel\"";
            return publisherName + des;
        }
    }

    class ScienceFieldStrategy extends FieldStrategy{
        public ScienceFieldStrategy(String name) {
            super(name);
        }

        @Override
        public String getField() {
            String des = " for Popular Science books, i.e. books on science which are written in non-technical language and aimed at the general reader.";
            return publisherName + des;
        }
    }
}
