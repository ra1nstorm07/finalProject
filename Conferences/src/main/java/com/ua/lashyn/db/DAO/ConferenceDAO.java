package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.Conference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceDAO {

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
            sqlException.printStackTrace();
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
            sqlException.printStackTrace();
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
            sqlException.printStackTrace();
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return conf;
    }

    public static void main(String[] args) {
        ConferenceDAO conferenceDAO = new ConferenceDAO();
        System.out.println(conferenceDAO.getConferencesByUserId(1));
    }

}

