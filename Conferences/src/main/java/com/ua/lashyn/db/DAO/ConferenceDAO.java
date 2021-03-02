package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.Conference;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConferenceDAO {

    private static final Logger log = Logger.getLogger(ConferenceDAO.class);

    public Conference readConference(ResultSet rs) throws SQLException {
        Conference conf = new Conference();
        conf.setId(rs.getLong("id"));
        conf.setName(rs.getString("name"));
        conf.setCommon_topic_id(rs.getLong("common_topic_id"));
        conf.setDate(rs.getString("date"));
        conf.setLocation(rs.getString("location"));
        return conf;
    }

    public Conference getConferenceById(long id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Conference conference = new Conference();
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCE_BY_ID);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                conference.setId(id);
                conference.setLocation(rs.getString("location"));
                conference.setDate(String.valueOf(rs.getDate("date")));
                conference.setCommon_topic_id(rs.getLong("common_topic_id"));
                conference.setName(rs.getString("name"));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conference;
    }

    public ArrayList<Conference> showConferencesList() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> showConferencesListOrderedByDate() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_ORDER_BY_DATE);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> showConferencesListOrderedByDateDesc() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_ORDER_BY_DATE_DESC);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> showConferencesListOrderedByTopicsNumber() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_ORDER_BY_TOPICS_NUMBER);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> showConferencesListOrderedByTopicsNumberDesc() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_ORDER_BY_TOPICS_NUMBER_DESC);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> showConferencesListOrderedByUsersNumber() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_ORDER_BY_USERS_NUMBER);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> showConferencesListOrderedByUsersNumberDesc() {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_ORDER_BY_USERS_NUMBER_DESC);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public ArrayList<Conference> getConferencesByUserId(long user_id) {
        ArrayList<Conference> conf = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCES_BY_USER_ID);
            preparedStatement.setLong(1, user_id);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                conf.add(readConference(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public Conference getConferenceByTopicId(long id){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCE_BY_TOPIC_ID);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                return readConference(rs);
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return null;
    }

    public long getConferenceIdByName(String name){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_CONFERENCE_BY_NAME);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                return readConference(rs).getId();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return 0;
    }

    public void deleteConference(long id){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_CONFERENCE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void adminUpdateConference(Conference conference){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADMIN_UPDATE_CONFERENCE);
            preparedStatement.setString(1, conference.getName());
            preparedStatement.setLong(2, conference.getCommon_topic_id());
            preparedStatement.setString(3, conference.getDate());
            preparedStatement.setString(4, conference.getLocation());
            preparedStatement.setLong(5, conference.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void addConference(Conference conference){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADD_CONFERENCE);
            preparedStatement.setString(1, conference.getName());
            preparedStatement.setLong(2, conference.getCommon_topic_id());
            preparedStatement.setString(3, conference.getDate());
            preparedStatement.setString(4, conference.getLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }
}

