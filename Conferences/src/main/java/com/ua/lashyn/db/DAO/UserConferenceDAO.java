package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.CommonTopic;
import com.ua.lashyn.db.entity.Speaker;
import com.ua.lashyn.db.entity.UserConference;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserConferenceDAO {

    private static final Logger log = Logger.getLogger(UserConferenceDAO.class);

    public UserConference readUserConference(ResultSet rs) throws SQLException {
        UserConference userConference = new UserConference();
        userConference.setId(rs.getLong("id"));
        userConference.setUser_id(rs.getLong("user_id"));
        userConference.setConference_id(rs.getLong("conference_id"));
        userConference.setArrived(rs.getBoolean("isArrived"));
        return userConference;
    }

    public long getUserConferenceId(long user_id, long conference_id){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        long id = 0;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_USER_CONFERENCE_ID);
            preparedStatement.setLong(1, user_id);
            preparedStatement.setLong(2, conference_id);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                id = rs.getLong("id");
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return id;
    }

    public void addUserConference(UserConference userConference){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.JOIN_CONFERENCE_AS_USER);
            preparedStatement.setLong(1, userConference.getUser_id());
            preparedStatement.setLong(2, userConference.getConference_id());
            preparedStatement.setBoolean(3, userConference.isArrived());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void deleteUserConference(long id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_USER_CONFERENCE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void adminUpdateUserConference(UserConference userConference){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADMIN_UPDATE_USER_CONFERENCE);
            preparedStatement.setLong(1, userConference.getUser_id());
            preparedStatement.setLong(2, userConference.getConference_id());
            preparedStatement.setBoolean(3, userConference.isArrived());
            preparedStatement.setLong(4, userConference.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public ArrayList<UserConference> showUserConferenceList(){
        ArrayList<UserConference> userConference = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_USER_CONFERENCE_LIST);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                userConference.add(readUserConference(rs));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException.getStackTrace());
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return userConference;
    }
}