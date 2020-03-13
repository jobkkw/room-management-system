package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ruanko.daos.RentLockDao;
import com.ruanko.model.Constant;
import com.ruanko.model.Order;
import com.ruanko.model.OrderBusiModel;
import com.ruanko.model.RentLock;
import com.ruanko.util.DBUtil;

public class RentLockDaoImpl implements RentLockDao {
	boolean flag = false;
	Connection conn = null;			
	ResultSet rs = null;
	String sql = "";
	
	
	@Override
	public List<RentLock> getRentLock(Order order, int state) {
		List<RentLock> rentLockList = new ArrayList<RentLock>();
		PreparedStatement psmt = null;
		Date checkindate = new Date(order.getCheckindate().getTime());
		Date checkoutdate = new Date(order.getCheckoutdate().getTime());	
		try {
			conn = DBUtil.getConnection();
			sql = "select * from t_rentlock where del = 0 "
					+ "and rentdate >= ? and rentdate < ? "
					+ "and t_h_id = ? and state = ? "
					+ "order by rentdate";	
			psmt= conn.prepareStatement(sql);
			psmt.setDate(1, checkindate);
			psmt.setDate(2, checkoutdate);
			psmt.setInt(3, order.getT_h_id());
			psmt.setInt(4, state);
			rs = psmt.executeQuery();
			if (rs.next()) {
				RentLock rentLock = new RentLock();
				rentLock.setId(rs.getInt("id"));
				rentLock.setT_h_id(rs.getInt("t_h_id"));
				rentLock.setRentdate(rs.getDate("rentdate"));
				rentLock.setState(rs.getInt("state"));
				rentLock.setDel(rs.getInt("del"));
				rentLockList.add(rentLock);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return rentLockList;
	}

	@Override
	public boolean save(Order order) {
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();
			sql = "insert into t_order (id, t_u_id, t_h_id, ordernum, checkindate,"
					+ "checkoutdate, state, unitprice, commentstate,"
					+ "total, del)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, order.getId());
			psmt.setInt(2, new HouseDaoImpl().getT_u_id());
			psmt.setInt(3, order.getT_h_id());
			psmt.setString(4, order.getOrdernum());
			psmt.setDate(5, (Date) order.getCheckindate());
			psmt.setDate(6, (Date) order.getCheckoutdate());
			psmt.setInt(7, order.getState());
			psmt.setFloat(8, order.getUnitprice());			
			psmt.setInt(9, order.getCommentstate());
			psmt.setFloat(10, order.getTotal());
			psmt.setInt(11, order.getDel());
			int count = psmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}		
		return flag;
	}

	@Override
	public List<OrderBusiModel> getHostUncheckedOrder(int userid, int state) {
		List<OrderBusiModel> orderBusilist = new ArrayList<OrderBusiModel>();
		PreparedStatement psmt = null;		
		try {
			conn = DBUtil.getConnection();
			sql = "select * from t_order o, t_house h, t_user u where o.t_h_id = h.id and o.t_u_id = u.id and o.t_u_id = ? and o.state = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.setInt(2, state);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderBusiModel orderBusi = new OrderBusiModel();
				orderBusi.setId(rs.getInt("o.id"));
				orderBusi.setOrdernum(rs.getString("o.ordernum"));
				orderBusi.setCheckindate(rs.getDate("o.checkindate"));
				orderBusi.setCheckoutdate(rs.getDate("o.checkoutdate"));
				orderBusi.setState(rs.getInt("o.state"));
				orderBusi.setUnitprice(rs.getFloat("o.unitprice"));
				orderBusi.setOrderdate(rs.getString("o.orderdate"));
				orderBusi.setCommentstate(rs.getInt("o.commentstate"));
				orderBusi.setTotal(rs.getFloat("o.total"));
				orderBusi.setDel(rs.getInt("o.del"));				
				orderBusi.setShotcut1(rs.getString("h.shotcut1"));
				orderBusi.setHousename(rs.getString("h.name"));
				orderBusi.setUsername(rs.getString("u.name"));
				orderBusi.setUserid(rs.getInt("u.id"));
				orderBusi.setChecktime(rs.getString("o.orderdate"));
				orderBusilist.add(orderBusi);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}					
		return orderBusilist;
	}

	@Override
	public boolean save(RentLock rentLock) {		
		PreparedStatement psmt = null;
		int num = 0;
		conn = DBUtil.getConnection();
		sql = "insert into t_rentlock (t_h_id, rentdate, state, del) values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rentLock.getT_h_id());
			psmt.setDate(2, rentLock.getRentdate());
			psmt.setInt(3, rentLock.getState());
			psmt.setInt(4, Constant.NOT_DELETED);
			num = psmt.executeUpdate();
			if (num != 0) {
				flag = true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		return flag;
	}

	@Override
	public List<OrderBusiModel> getHostCheckedOrder(int userid, int state) {
		List<OrderBusiModel> orderBusilist = new ArrayList<OrderBusiModel>();
		PreparedStatement psmt = null;		
		try {
			conn = DBUtil.getConnection();
			sql = "select * from t_dealorder o, t_house h, t_user u where o.t_h_id = h.id and o.t_u_id = u.id and o.t_u_id = ? and o.state = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, userid);
			psmt.setInt(2, state);
			rs = psmt.executeQuery();
			while (rs.next()) {
				OrderBusiModel orderBusi = new OrderBusiModel();
				orderBusi.setId(rs.getInt("o.id"));
				orderBusi.setOrdernum(rs.getString("o.ordernum"));
				orderBusi.setCheckindate(rs.getDate("o.checkindate"));
				orderBusi.setCheckoutdate(rs.getDate("o.checkoutdate"));
				orderBusi.setState(rs.getInt("o.state"));
				orderBusi.setUnitprice(rs.getFloat("o.unitprice"));
				orderBusi.setOrderdate(rs.getString("o.orderdate"));
				orderBusi.setCommentstate(rs.getInt("o.commentstate"));
				orderBusi.setTotal(rs.getFloat("o.total"));
				orderBusi.setDel(rs.getInt("o.del"));				
				orderBusi.setShotcut1(rs.getString("h.shotcut1"));
				orderBusi.setHousename(rs.getString("h.name"));
				orderBusi.setUsername(rs.getString("u.name"));
				orderBusi.setUserid(rs.getInt("u.id"));
				orderBusi.setChecktime(rs.getString("o.orderdate"));
				orderBusilist.add(orderBusi);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}					
		return orderBusilist;
	}

		
	@Override
	public boolean abolishOrder(int setState, int orderid, int state) {
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
	public boolean unsubscribeOrder(int setState, int orderid, int state) {
		PreparedStatement psmt = null;
		int num = 0;
		try {
			conn = DBUtil.getConnection();
			sql = "update t_dealorder set state = ? where id = ? and state = ?";
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

	
	
	
	
}
