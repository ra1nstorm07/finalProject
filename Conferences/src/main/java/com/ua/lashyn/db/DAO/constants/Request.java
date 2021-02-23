package com.ua.lashyn.db.DAO.constants;

public class Request {
    public static final String INSERT_USER = "INSERT INTO user (name, surname, address, email, password, admin_privilegies) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String USER_JOIN_CONFERENCE = "INSERT INTO user (conference_id) VALUE (?) WHERE id = ?";
    public static final String VALIDATE = "SELECT * FROM user where email = ? and password = ?";
    public static final String GET_CONFERENCES = "SELECT * FROM conference";
    public static final String GET_CONFERENCE_BY_ID = "SELECT * FROM conference WHERE id = ?";
    public static final String GET_CONFERENCES_BY_USER_ID = "SELECT * FROM conference WHERE id IN (SELECT conference_id FROM user_conference WHERE user_id = ?)";
    public static final String GET_USERS = "SELECT * FROM user";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String GET_COMMON_TOPICS = "SELECT * FROM common_topic";
    public static final String GET_COMMON_TOPIC_BY_ID = "SELECT * FROM common_topic WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE user SET name = ?, surname = ?, address = ?, password = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_USER = "UPDATE user SET name = ?, surname = ?, address = ?, email = ?, password = ?, admin_privilegies = ? WHERE id = ?";
}
