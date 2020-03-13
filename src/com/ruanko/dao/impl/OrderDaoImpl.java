package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ruanko.daos.OrderDao;
import com.ruanko.model.Constant;
import com.ruanko.model.Order;
import com.ruanko.util.DBUtil;

public class OrderDaoImpl implements OrderDao {
	boolean flag = false;
	Connection conn = null;			
	ResultSet rs = null;
	String sql = "";
	
	
	@Override 
	public boolean updateState(int setState,int orderid, int state) {		
		PreparedStatement psmt = null;
		int num = 0;
		try {
			conn = DBUtil.getConnection();
			sql = "update t_order set state = ? where id = ? and state = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, setState);
			psmt.setInt(2, orderid);
			psmt.setInt(3, state);
			num = psmt.executeUpdate();
			if (num != 0) {
				flag = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return flag;
	}


	@Override
	public Order getOrderById(int orderid) {
		PreparedStatement psmt = null;
		Order order = null;
		try {
			conn = DBUtil.getConnection();
			sql = "select * from t_order where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, orderid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				order = new Order();
				order.setId(rs.getInt("id"));
				order.setT_u_id(rs.getInt("t_u_id"));
				order.setT_h_id(rs.getInt("t_h_id"));
				order.setOrdernum(rs.getString("ordernum"));
				order.setCheckindate(rs.getDate("checkindate"));
				order.setCheckoutdate(rs.getDate("checkoutdate"));
				order.setState(rs.getInt("state"));
				order.setUnitprice(rs.getFloat("unitprice"));
				order.setOrderdate(rs.getString("orderdate"));
				order.setCommentstate(rs.getInt("commentstate"));
				order.setTotal(rs.getFloat("total"));
				order.setDel(rs.getInt("del"));				
			}					
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return order;
	}


	@Override
	public boolean updateConflictOrderByState(Order order, int state) {
		PreparedStatement psmt = null;	
		int num = 0;
		conn = DBUtil.getConnection();		
		sql = "update t_order set state = ? where id != ? and t_h_id = ? and state = ? and"
				+ "((checkindate < ? and checkoutdate > ? and checkoutdate <= ?)"
				+ "or (checkindate >= ? and checkindate < ? and checkoutdate > ? and checkoutdate <= ?)"
				+ "or (checkindate >= ? and checkindate < ? and checkoutdate > ?)"
				+ "or (checkindate < ? and checkindate > ?))";		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, Constant.ORDER_REFUSED);
			psmt.setInt(2, order.getId());
			psmt.setInt(3, order.getT_h_id());
			psmt.setInt(4, state);
			
			psmt.setDate(5, order.getCheckindate());
			psmt.setDate(6, order.getCheckindate());
			psmt.setDate(7, order.getCheckoutdate());
					
			psmt.setDate(8, order.getCheckindate());
			psmt.setDate(9, order.getCheckoutdate());
			psmt.setDate(10, order.getCheckindate());
			psmt.setDate(11, order.getCheckoutdate());
			
			psmt.setDate(12, order.getCheckindate());
			psmt.setDate(13, order.getCheckoutdate());
			psmt.setDate(14, order.getCheckoutdate());
			
			psmt.setDate(15, order.getCheckindate());
			psmt.setDate(16, order.getCheckoutdate());
			
			num = psmt.executeUpdate();
			if (num != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}
