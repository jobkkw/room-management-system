package com.ruanko.util;

import java.sql.*;

public class DBUtil {	
				
	private static String url="jdbc:mysql://localhost:3306/shortrent?useUnicode=true&amp;"+"characterEncoding=utf8";
	private static String user="xuhaifeng";
	private static String pass="04146374";
			
	public static Connection getConnection () {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return conn;
	}
	
	public static void closeConnection (Connection conn) {
		try {
			if ((conn != null) && (!conn.isClosed())) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closePreparedStatement (PreparedStatement psmt) {
		try {
			if ((psmt != null) && (!psmt.isClosed())) {
				psmt.close();
				psmt = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeConnen (ResultSet rs) {
		try {
			if ((rs != null) && (!rs.isClosed())) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
