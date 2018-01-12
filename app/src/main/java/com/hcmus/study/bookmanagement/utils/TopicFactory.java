package com.hcmus.study.bookmanagement.utils;

import com.hcmus.study.bookmanagement.model.Topic;

import java.util.List;

public class TopicFactory{

    public Topic getTopic(TopicType topicType){
        switch (topicType) {
            case ALL: {
                return new All();
            }
            case SCIENCE: {
                return new Science();
            }
            case GUIDE: {
                return new Guide();
            }
            case COMICS: {
                return new Comics();
            }
            case JOURNALS: {
                return new Journals();
            }
            case COOKBOOKS: {
                return new Cookbooks();
            }
            default: {
                return null;
            }
        }
    }

    class All extends Topic {

        @Override
        public String getName() {
            name = "All books";
            return name;
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Science extends Topic {

        @Override
        public String getName() {
            name = "Science";
            return name;
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Journals extends Topic {

        @Override
        public String getName() {
            name = "Journals";
            return name;
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Guide extends Topic {

        @Override
        public String getName() {
            name = "Guide";
            return name;
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Cookbooks extends Topic {

        @Override
        public String getName() {
            name = "Cookbooks";
            return name;
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Comics extends Topic {

        @Override
        public String getName() {
            name = "Comics";
            return name;
        }
    }


    public enum TopicType {
        ALL,
        SCIENCE,
        GUIDE,
        COMICS,
        JOURNALS,
        COOKBOOKS
    }
}



