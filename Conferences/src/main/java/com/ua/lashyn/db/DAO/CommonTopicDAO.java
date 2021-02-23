package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.CommonTopic;
import com.ua.lashyn.db.entity.Conference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommonTopicDAO {

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
            sqlException.printStackTrace();
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
            sqlException.printStackTrace();
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return commonTopic;
    }
}
