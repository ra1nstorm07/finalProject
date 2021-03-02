package com.ua.lashyn.db.entity;

public class Topic {
    private long id;
    private String name;
    private long common_topic_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCommon_topic_id() {
        return common_topic_id;
    }

    public void setCommon_topic_id(long common_topic_id) {
        this.common_topic_id = common_topic_id;
    }
}
