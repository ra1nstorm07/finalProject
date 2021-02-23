package com.ua.lashyn.db.entity;

public class Conference {
    private long id;
    private String name;
    private long common_topic_id;
    private String date;
    private String location;


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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getCommon_topic_id() {
        return common_topic_id;
    }

    public void setCommon_topic_id(long common_topic_id) {
        this.common_topic_id = common_topic_id;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", common_topic_id=" + common_topic_id +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
