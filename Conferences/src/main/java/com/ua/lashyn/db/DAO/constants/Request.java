package com.ua.lashyn.db.DAO.constants;

public class Request {
    public static final String INSERT_USER = "INSERT INTO user (name, surname, address, email, password, admin_privilegies) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String VALIDATE = "SELECT * FROM user where email = ? and password = ?";
    public static final String GET_CONFERENCES = "SELECT * FROM conference";
    public static final String GET_CONFERENCE_BY_ID = "SELECT * FROM conference WHERE id = ?";
    public static final String GET_CONFERENCE_BY_NAME = "SELECT * FROM conference WHERE name = ?";
    public static final String GET_CONFERENCE_BY_TOPIC_ID = "SELECT * FROM conference WHERE common_topic_id = (SELECT common_topic_id FROM topic WHERE id = ?)";
    public static final String GET_CONFERENCES_BY_USER_ID = "SELECT * FROM conference WHERE id IN (SELECT conference_id FROM user_conference WHERE user_id = ?)";
    public static final String GET_CONFERENCES_ORDER_BY_DATE = "SELECT * FROM conference ORDER BY date";
    public static final String GET_CONFERENCES_ORDER_BY_DATE_DESC = "SELECT * FROM conference ORDER BY date DESC";
    public static final String GET_CONFERENCES_ORDER_BY_TOPICS_NUMBER = "SELECT id, name, conference.common_topic_id, date, location FROM conference " +
                                                                        "JOIN (SELECT common_topic_id, COUNT(*) AS total FROM topic GROUP BY common_topic_id ORDER BY total DESC) as table2 ON conference.common_topic_id = table2.common_topic_id order by total;";
    public static final String GET_CONFERENCES_ORDER_BY_TOPICS_NUMBER_DESC = "SELECT id, name, conference.common_topic_id, date, location FROM conference " +
                                                                            "JOIN (SELECT common_topic_id, COUNT(*) AS total FROM topic GROUP BY common_topic_id ORDER BY total DESC) as table2 ON conference.common_topic_id = table2.common_topic_id order by total DESC;";
    public static final String GET_CONFERENCES_ORDER_BY_USERS_NUMBER = "SELECT id, name, common_topic_id, date, location FROM conference " +
                                                                        "JOIN (SELECT conference_id, COUNT(*) AS total FROM user_conference GROUP BY conference_id ORDER BY total DESC) AS table2 ON id = table2.conference_id order by total;";
    public static final String GET_CONFERENCES_ORDER_BY_USERS_NUMBER_DESC = "SELECT id, name, common_topic_id, date, location FROM conference " +
                                                                            "JOIN (SELECT conference_id, COUNT(*) AS total FROM user_conference GROUP BY conference_id ORDER BY total DESC) AS table2 ON id = table2.conference_id order by total DESC;";
    public static final String GET_USERS = "SELECT * FROM user";
    public static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String DELETE_FROM_USER = "DELETE FROM speaker WHERE user_id = ?;" +
                                            "DELETE FROM user_conference WHERE user_id = ?;" +
                                            "DELETE FROM user WHERE id = ?";
    public static final String DELETE_FROM_CONFERENCE = "DELETE FROM conference WHERE id = ?";
    public static final String DELETE_FROM_COMMON_TOPIC = "DELETE FROM conference WHERE common_topic_id = ?;" +
                                                          "DELETE FROM topic WHERE common_topic_id = ?;" +
                                                          "DELETE FROM common_topic WHERE id = ?";
    public static final String DELETE_FROM_TOPIC =  "DELETE FROM speaker WHERE topic_id = ?;" +
                                                    "DELETE FROM topic WHERE id = ?";
    public static final String DELETE_FROM_SPEAKER = "DELETE FROM user_conference WHERE user_id = (SELECT user_id FROM speaker WHERE id = ?) AND conference_id = ?;" +
                                                     "DELETE FROM speaker WHERE id = ?;" +
                                                     "DELETE FROM topic WHERE id = ?";
    public static final String DELETE_FROM_USER_CONFERENCE = "DELETE FROM user_conference WHERE id = ?";
    public static final String JOIN_CONFERENCE_AS_USER = "INSERT INTO user_conference (user_id, conference_id, isArrived) VALUES (?, ?, ?)";
    public static final String JOIN_CONFERENCE_AS_SPEAKER = "INSERT INTO user_conference (user_id, conference_id, isArrived) VALUES (?, ?, ?);" +
                                                            "INSERT INTO speaker (user_id, topic_id) VALUES (?, ?)";
    public static final String ADD_USER = "INSERT INTO user (name, surname, address, email, password, admin_privilegies) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String ADD_CONFERENCE = "INSERT INTO conference (name, common_topic_id, date, location) VALUES (?, ?, ?, ?)";
    public static final String ADD_COMMON_TOPIC = "INSERT INTO common_topic (name) VALUE (?)";
    public static final String ADD_TOPIC = "INSERT INTO topic (name, common_topic_id) VALUES (?, ?)";
    public static final String ADD_SPEAKER = "INSERT INTO speaker (user_id, topic_id) VALUES (?, ?)";
    public static final String GET_COMMON_TOPICS = "SELECT * FROM common_topic";
    public static final String GET_COMMON_TOPIC_BY_ID = "SELECT * FROM common_topic WHERE id = ?";
    public static final String GET_COMMON_TOPIC_BY_NAME = "SELECT * FROM common_topic WHERE name = ?";
    public static final String GET_TOPIC_ID_BY_NAME = "SELECT * FROM topic WHERE name = ?";
    public static final String GET_TOPICS = "SELECT * FROM topic";
    public static final String GET_SPEAKERS = "SELECT * FROM speaker";
    public static final String GET_SPEAKER_ID = "SELECT * FROM speaker WHERE user_id = ? and topic_id = ?";
    public static final String GET_USER_CONFERENCE_ID = "SELECT * FROM user_conference WHERE user_id = ? AND conference_id = ?";
    public static final String GET_USER_CONFERENCE_LIST = "SELECT * FROM user_conference";
    public static final String UPDATE_USER = "UPDATE user SET name = ?, surname = ?, address = ?, password = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_USER = "UPDATE user SET name = ?, surname = ?, address = ?, email = ?, password = ?, admin_privilegies = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_CONFERENCE = "UPDATE conference SET name = ?, common_topic_id = ?, date = ?, location = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_COMMON_TOPIC = "UPDATE common_topic SET name = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_TOPIC = "UPDATE topic SET name = ?, common_topic_id = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_SPEAKER = "UPDATE speaker SET user_id = ?, topic_id = ? WHERE id = ?";
    public static final String ADMIN_UPDATE_USER_CONFERENCE = "UPDATE user_conference SET user_id = ?, conference_id = ?, isArrived = ? WHERE id = ?";
}
