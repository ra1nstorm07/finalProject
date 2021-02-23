package com.ua.lashyn.db.DAO.connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionManagement {

    public static Connection getConnection() {
        Connection conn = null;
        Properties properties=new Properties();
        properties.setProperty("useUnicode","true");
        properties.setProperty("characterEncoding","UTF-8");
        String url = "jdbc:mysql://localhost:3306/ConferencesDatabase?user=root&password=Alex7778&serverTimezone=Europe/Kiev&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
    }


    public static void closing(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (connection != null) {
                connection.close();
                preparedStatement.close();
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}
