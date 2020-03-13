package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ruanko.daos.DealOrderDao;
import com.ruanko.model.Constant;
import com.ruanko.model.Order;
import com.ruanko.util.DBUtil;

public class DealOrderDaoImpl implements DealOrderDao {
	boolean flag = false;
	Connection conn = null;			
	ResultSet rs = null;
	String sql = "";
	
	@Override
	public boolean save(Order order) {
		PreparedStatement psmt = null;
		int num = 0;
		conn = DBUtil.getConnection();
		sql = "insert into t_dealorder (t_u_id, t_h_id, ordernum, checkindate, checkoutdate, unitprice, orderdate, total, state, commentstate, del) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, order.getT_u_id());
			psmt.setInt(2, order.getT_h_id());
			psmt.setString(3, order.getOrdernum());
			psmt.setDate(4, order.getCheckindate());
			psmt.setDate(5, order.getCheckoutdate());
			psmt.setFloat(6, order.getUnitprice());
			psmt.setString(7, order.getOrderdate());
			psmt.setFloat(8, order.getTotal());
			psmt.setInt(9, Constant.ORDER_PASSED);
			psmt.setInt(10, Constant.NOT_COMMENTED);
			psmt.setInt(11, Constant.NOT_DELETED);
			num = psmt.executeUpdate();
			if (num != 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
