package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.CommonTopic;
import com.ua.lashyn.db.entity.Topic;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopicDAO {

    private static final Logger log = Logger.getLogger(TopicDAO.class);

    public Topic readTopic(ResultSet rs) throws SQLException {
        Topic topic = new Topic();
        topic.setId(rs.getLong("id"));
        topic.setName(rs.getString("name"));
        topic.setCommon_topic_id(rs.getLong("common_topic_id"));
        return topic;
    }

    public void createTopic(String name, long common_topic_id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADD_TOPIC);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, common_topic_id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }



    public ArrayList<Topic> showTopicList(){
        ArrayList<Topic> topics = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_TOPICS);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                topics.add(readTopic(rs));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException.getStackTrace());
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return topics;
    }

    public void deleteTopic(long id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_TOPIC);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void addTopic(Topic topic){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADD_TOPIC);
            preparedStatement.setString(1, topic.getName());
            preparedStatement.setLong(2, topic.getCommon_topic_id());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public long getTopicIdByName(String name) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_TOPIC_ID_BY_NAME);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if(rs.next())
                return readTopic(rs).getId();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
        return 0;
    }

    public void adminUpdateTopic(Topic topic){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADMIN_UPDATE_TOPIC);
            preparedStatement.setString(1, topic.getName());
            preparedStatement.setLong(2, topic.getCommon_topic_id());
            preparedStatement.setLong(3, topic.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }
}
