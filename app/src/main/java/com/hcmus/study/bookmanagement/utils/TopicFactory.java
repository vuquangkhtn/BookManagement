package com.hcmus.study.bookmanagement.utils;

import com.hcmus.study.bookmanagement.model.Topic;

public class TopicFactory{

    public Topic getTopic(TopicType topicType){
        switch (topicType) {
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

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Science extends Topic {

        @Override
        public void getName() {
            name = "Science";
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Journals extends Topic {

        @Override
        public void getName() {
            name = "Journals";
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Guide extends Topic {

        @Override
        public void getName() {
            name = "Guide";
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Cookbooks extends Topic {

        @Override
        public void getName() {
            name = "Cookbooks";
        }
    }

    /**
     * Created by CPU10584-local on 11-Jan-18.
     */
    class Comics extends Topic {

        @Override
        public void getName() {
            name = "Comics";
        }
    }


    public enum TopicType {
        SCIENCE,
        GUIDE,
        COMICS,
        JOURNALS,
        COOKBOOKS
    }
}



