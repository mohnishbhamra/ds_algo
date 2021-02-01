package com.blah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BVTSyncHelper {
    public static Connection connection = null;

    public static void setConnectionUrl(String connectionUrl) {
        BVTSyncHelper.connectionUrl = connectionUrl;
    }

    public static void setDbUser(String dbUser) {
        BVTSyncHelper.dbUser = dbUser;
    }

    public static void setPassword(String password) {
        BVTSyncHelper.password = password;
    }

    private static String connectionUrl = "jdbc:mysql://127.0.0.1:3306/advocate";
    private static String dbUser = "root";
    private static String password = "root";

    public static void connectionSetup() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionUrl, dbUser, password);
    }

    public static int countFromSql(String query) throws SQLException, ClassNotFoundException {
        connectionSetup();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        int result = resultSet.getInt(1);
        closeConnection();
        return result;
    }

    public static int execFromSql(String query) throws SQLException, ClassNotFoundException {
        connectionSetup();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(query);
        closeConnection();
        return result;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }


}
