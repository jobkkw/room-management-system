package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ruanko.daos.UserDao;
import com.ruanko.model.User;
import com.ruanko.util.AppException;
import com.ruanko.util.DBUtil;

public class UserDaoImpl implements UserDao {

	boolean flag = false;
	Connection conn = null;		
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String sql = "";
	int id = 0;
	
	@Override
	public boolean isExist(String name) throws AppException{
		
		try {
			conn = DBUtil.getConnection();
			sql = "select id from t_user where name = ?";		
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			//throw new AppException("com.ruanko.dao.impl.UserDaoImpl.isExist");
			e.printStackTrace();
		} finally {
			DBUtil.closeConnen(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}		
		return flag;
	}

	@Override
	public boolean save(User user) throws AppException{				
		try {			
			conn = DBUtil.getConnection();
			sql = "insert into t_user (name, password, mobile, email)" + "values (?, ?, ?, ?)";		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getMobile());
			psmt.setString(4, user.getEmail());
			int count = psmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}						
		} catch (Exception e) {
			//throw new AppException("com.ruanko.dao.impl.UserDaoImpl.save");
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}						
		return flag;
	}

	@Override
	public int login(String name, String password) throws AppException {			
		try {
			conn = DBUtil.getConnection();
			sql = "select id from t_user where name = ? and password = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}			
		} catch (Exception e) {
			//throw new AppException("com.ruanko.dao.impl.UserDaoImpl.login");
			e.printStackTrace();
		} finally {
			DBUtil.closeConnen(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}		
		return id;
	}

	@Override
	public User getUser(int id) throws AppException {
		User user = new User();
		try {
			conn = DBUtil.getConnection();
			sql = "select name, password, mobile, email from t_user where id = ?";	
			psmt= conn.prepareStatement(sql);			
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));				
			}
		} catch (Exception e) {
			//throw new AppException("com.ruanko.dao.impl.UserDaoImpl.getUser");
			e.printStackTrace();
		} finally {
			DBUtil.closeConnen(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}								
		return user;
	}

}
