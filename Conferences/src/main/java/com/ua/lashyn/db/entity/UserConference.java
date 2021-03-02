package com.ua.lashyn.db.entity;

public class UserConference {
    private long id;
    private long user_id;
    private long conference_id;
    private boolean isArrived;

    public boolean isArrived() {
        return isArrived;
    }

    public void setArrived(boolean arrived) {
        isArrived = arrived;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getConference_id() {
        return conference_id;
    }

    public void setConference_id(long conference_id) {
        this.conference_id = conference_id;
    }

    @Override
    public String toString() {
        return "UserConference{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", conference_id=" + conference_id +
                ", isArrived=" + isArrived +
                '}';
    }
}
