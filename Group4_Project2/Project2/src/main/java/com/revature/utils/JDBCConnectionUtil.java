package com.revature.utils;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JDBCConnectionUtil {
	
	private static Connection conn = null;

	public static Connection getConnection() {
		
		try {
			
			if (conn == null) {
				
				Class.forName("org.postgresql.Driver");
				
				Properties props = new Properties();
				InputStream input = JDBCConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
				
				props.load(input);
				
				String url = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
				conn = DriverManager.getConnection(url, username, password);
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public static void main(String[] args) {
		
		Connection conn = JDBCConnectionUtil.getConnection();
		
		if (conn != null) {
			System.out.println("Connected successfully");
		} else {
			System.out.println("Connection unsuccessful");
		}
		
		
	}

}
