package com.ua.lashyn.db.DAO;

import com.ua.lashyn.db.DAO.connection.ConnectionManagement;
import com.ua.lashyn.db.DAO.constants.Request;
import com.ua.lashyn.db.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    private static UserDAO userDAO;
    private static final Logger log = Logger.getLogger(UserDAO.class);

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void registration(User user) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setBoolean(6, user.getAdmin_privilegies());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public User updateUser(User user){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setLong(5, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
        return getUserById(user.getId());
    }

    public void adminUpdateUser(User user){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADMIN_UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setBoolean(6, user.getAdmin_privilegies());
            preparedStatement.setLong(7, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void deleteUser(long id){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.DELETE_FROM_USER);
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

    public void addUser(User user){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.ADD_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setBoolean(6, user.getAdmin_privilegies());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void joinConferenceAsUser(long user_id, long conference_id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.JOIN_CONFERENCE_AS_USER);
            preparedStatement.setLong(1, user_id);
            preparedStatement.setLong(2, conference_id);
            preparedStatement.setBoolean(3, false);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public void joinConferenceAsSpeaker(long user_id, long conference_id, long topic_id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(Request.JOIN_CONFERENCE_AS_SPEAKER);
            preparedStatement.setLong(1, user_id);
            preparedStatement.setLong(2, conference_id);
            preparedStatement.setBoolean(3, false);
            preparedStatement.setLong(4, user_id);
            preparedStatement.setLong(5, topic_id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement);
        }
    }

    public boolean logInValidate (String email,String password) {
        boolean status=false;
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            preparedStatement = connection.prepareStatement(Request.VALIDATE);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            status = rs.next();
        }catch(SQLException sqlException){
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return status;
    }

    public long getIdByEmail(String email){
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        long id = 0;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
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

    public User getUserById(long id) {
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(Request.GET_USER_BY_ID);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAdmin_privilegies(rs.getBoolean("admin_privilegies"));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return user;
    }

    public User readUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAdmin_privilegies(rs.getBoolean("admin_privilegies"));
        return user;
    }

    public ArrayList<User> showUsersList() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = ConnectionManagement.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(Request.GET_USERS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(readUser(rs));
            }
        } catch (SQLException sqlException) {
            log.error(sqlException);
        } finally {
            ConnectionManagement.closing(connection, preparedStatement, rs);
        }
        return users;
    }
}
