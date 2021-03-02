package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.CommonTopic;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommonTopicDAO {

    private static final Logger log = Logger.getLogger(CommonTopicDAO.class);

    public CommonTopic readCommonTopic(ResultSet rs) throws SQLException {
        CommonTopic commonTopic = new CommonTopic();
        commonTopic.setId(rs.getLong("id"));
        commonTopic.setName(rs.getString("name"));
        return commonTopic;
    }

    public ArrayList<CommonTopic> showCommonTopicList(){
        ArrayList<CommonTopic> commonTopics = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_COMMON_TOPICS);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                commonTopics.add(readCommonTopic(rs));
            }

        } catch (SQLException sqlException) {
            log.error(sqlException.getStackTrace());
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return commonTopics;
    }

    public CommonTopic getCommonTopicById(long id){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        CommonTopic commonTopic = new CommonTopic();
        try {
            preparedStatement = connection.prepareStatement(Request.GET_COMMON_TOPIC_BY_ID);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                commonTopic.setId(id);
                commonTopic.setName(rs.getString("name"));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return commonTopic;
    }

    public String getCommonTopicName(long id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_COMMON_TOPIC_BY_ID);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                return readCommonTopic(rs).getName();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return "";
    }

    public long getCommonTopicIdByName(String name){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_COMMON_TOPIC_BY_NAME);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                return readCommonTopic(rs).getId();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return 0;
    }

    public void adminUpdateCommonTopic(CommonTopic commonTopic){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADMIN_UPDATE_COMMON_TOPIC);
            preparedStatement.setString(1, commonTopic.getName());
            preparedStatement.setLong(2, commonTopic.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void deleteCommonTopic(long id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_COMMON_TOPIC);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void addCommonTopic(CommonTopic commonTopic) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADD_COMMON_TOPIC);
            preparedStatement.setString(1, commonTopic.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }
}
