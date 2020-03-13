package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ruanko.daos.ManagerDao;
import com.ruanko.model.Manager;
import com.ruanko.util.DBUtil;

public class ManagerDaoImpl implements ManagerDao{
	boolean flag = false;
	Connection conn = null;			
	ResultSet rs = null;
	String sql = "";
	
	
	@Override
	public int login(String name, String password) {
		PreparedStatement psmt = null;
		int id = 0;
		try {
			conn = DBUtil.getConnection();
			sql = "select id from t_manager where name = ? and password = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return id;
	}


	@Override
	public Manager getManager(int id) {
		PreparedStatement psmt = null;
		Manager manager = new Manager();
		try {
			conn = DBUtil.getConnection();
			sql = "select name, password, del from t_manager where id = ?";	
			psmt= conn.prepareStatement(sql);			
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				manager.setName(rs.getString("name"));
				manager.setPassword(rs.getString("password"));
				manager.setDel(rs.getInt("del"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 								
		return manager;
	}


}
