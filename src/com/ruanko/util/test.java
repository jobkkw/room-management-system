package com.ruanko.util;

import java.sql.Connection;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		System.out.print(conn);
		DBUtil.closeConnection(conn);		
	}

}
