package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.CommonTopic;
import com.ua.lashyn.db.entity.Speaker;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpeakerDAO {

    private static final Logger log = Logger.getLogger(SpeakerDAO.class);

    public Speaker readSpeaker(ResultSet rs) throws SQLException {
        Speaker speaker = new Speaker();
        speaker.setId(rs.getLong("id"));
        speaker.setUser_id(rs.getLong("user_id"));
        speaker.setTopic_id(rs.getLong("topic_id"));
        return speaker;
    }

    public ArrayList<Speaker> showSpeakerList(){
        ArrayList<Speaker> speakers = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_SPEAKERS);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                speakers.add(readSpeaker(rs));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException.getStackTrace());
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return speakers;
    }

    public void deleteSpeaker(long id, long conference_id, long topic_id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_SPEAKER);
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, conference_id);
            preparedStatement.setLong(3, topic_id);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void addSpeaker(Speaker speaker){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADD_SPEAKER);
            preparedStatement.setLong(1, speaker.getUser_id());
            preparedStatement.setLong(2, speaker.getTopic_id());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public long getSpeakerIdByUserAndTopicId(long user_id, long topic_id){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        long id = 0;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_SPEAKER_ID);
            preparedStatement.setLong(1, user_id);
            preparedStatement.setLong(2, topic_id);
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

    public void adminUpdateSpeaker(Speaker speaker){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADMIN_UPDATE_SPEAKER);
            preparedStatement.setLong(1, speaker.getUser_id());
            preparedStatement.setLong(2, speaker.getTopic_id());
            preparedStatement.setLong(3, speaker.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }
}
