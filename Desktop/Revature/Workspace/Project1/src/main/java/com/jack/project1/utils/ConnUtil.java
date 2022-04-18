package com.jack.project1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtil {
	private static Connection conn;
	
	public ConnUtil() {
		String url = System.getenv("MY_CONNECTION");
        try {
            // A factory - pass in string details for any type of database.
            // The DriverManager factory will give you back a connection
            // implementation specifically for Postgres.
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static Connection getInstance() {
		String url = System.getenv("MY_CONNECTION");
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url);
			}
			catch (SQLException e) {
				
			}
		}
		return conn;
	}

}
