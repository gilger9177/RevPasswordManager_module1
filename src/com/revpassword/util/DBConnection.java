package com.revpassword.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USERNAME = "revpm";
    private static final String PASSWORD = "revpm";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
