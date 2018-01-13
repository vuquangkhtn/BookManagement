package com.hcmus.study.bookmanagement.model;

import com.hcmus.study.bookmanagement.utils.TopicFactory;

/**
 * Created by CPU10584-local on 11-Jan-18.
 */

public abstract class Topic {
    public String id;
    public String name;
    public TopicFactory.TopicType type;
    public abstract String getName();
}