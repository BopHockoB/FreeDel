package ua.nure.freedel.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static String dbHost = "localhost";
    private static String dbPort = "3306";
    private static String dbUser = "root";
    private static String dbPass = "Vanilka125";
    private static String dbName = "freedel";
    public static Connection getDBSQlConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort +
                "/" + dbName;
        return DriverManager.getConnection(connectionString, dbUser,
                dbPass);
    }
}

