package com.tts.xiaoliji.mavenplugin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    public static Connection getConnection(String driverclass, String connectionurl, String userid, String password)
            throws SQLException {
        try {
            Class.forName(driverclass);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(connectionurl, userid, password);
        conn.setAutoCommit(false);
        return conn;
    }

}
