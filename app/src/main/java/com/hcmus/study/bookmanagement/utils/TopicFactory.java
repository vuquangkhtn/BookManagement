package com.hcmus.study.bookmanagement.utils;

import com.hcmus.study.bookmanagement.model.Topic;

import java.util.List;

public class TopicFactory{

    public Topic getTopic(TopicType topicType){
        switch (topicType) {
            case ALL: {
                All all = new All();
                all.getName();
                return all;
            }
            case SCIENCE: {
                Science science = new Science();
                science.getName();
                return science;
            }
            case GUIDE: {
                Guide guide = new Guide();
                guide.getName();
                return guide;
            }
            case COMICS: {
                Comics comics = new Comics();
                comics.getName();
                return comics;
            }
            case JOURNALS: {
                Journals Journals = new Journals();
                Journals.getName();
                return Journals;
            }
            case COOKBOOKS: {
                Cookbooks Cookbooks = new Cookbooks();
                Cookbooks.getName();
                return Cookbooks;
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
            type = TopicType.ALL;
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
            type = TopicType.SCIENCE;
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
            type = TopicType.JOURNALS;
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
            type = TopicType.GUIDE;
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
            type = TopicType.COOKBOOKS;
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
            type = TopicType.COMICS;
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



