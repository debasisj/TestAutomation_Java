package com.dbschenker.framework.utilities;

import com.dbschenker.framework.config.Settings;

import java.sql.*;

public class DatabaseUtil {

    private static String connectionUrl = Settings.DatabaseInstanceConnectionUrl;


    /*
    Open a connection to database
     */
    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName(Settings.SQLServerJDBCClass).newInstance();
            conn =  DriverManager.getConnection(connectionUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeDbConnecttion() throws SQLException {
        connect().close();
    }

    public static ResultSet executeQuery(String query){
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connect().createStatement();
            resultSet = statement.executeQuery(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return resultSet;
    }
}
