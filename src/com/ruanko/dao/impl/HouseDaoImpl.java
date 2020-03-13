package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.ruanko.daos.HouseDao;
import com.ruanko.model.Constant;
import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.model.User;
import com.ruanko.util.AppException;
import com.ruanko.util.DBUtil;

public class HouseDaoImpl implements HouseDao {
	
	boolean flag = false;
	Connection conn = null;			
	ResultSet rs = null;
	String sql = "";
	
	
	//根据用户ID查询房屋名称是否重复
	public int checkName (int userId, String name) {
		int num = 0;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();
			sql = "select id from t_house where t_u_id = ? and name = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, userId);
			psmt.setString(2, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				num = 1;
			}			
		} catch (Exception e) {
			//throw new AppException("com.ruanko.dao.impl.UserDaoImpl.login");
			e.printStackTrace();
		}		
		return num;
	}
	
	//通过账号、密码得到用户ID
	public int getT_u_id () {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id = 0;
		PreparedStatement psmt = null;
		try {
			conn = DBUtil.getConnection();
			sql = "select id from t_user where name = ? and password = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}			
		} catch (Exception e) {
			//throw new AppException("com.ruanko.dao.impl.UserDaoImpl.login");
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public boolean save(House house) throws AppException {
		int num = checkName(getT_u_id(), house.getName());
		if (num == 0) {					
			PreparedStatement psmt = null;
			try {
				conn = DBUtil.getConnection();
				sql = "insert into t_house (t_u_id, name, renttype, address, dayprice,"
						+ "bill, kind, guestnum, bednum, bedroomnum, "
						+ "roomnum, bedtype, toiletnum, roomdesc, userule,"
						+ "checkinTime, checkoutTime, minday, maxday, refundday,"
						+ "payrule, picture1, shotcut1, picture2, shotcut2,"
						+ " picture3, shotcut3, facility, area, state, del)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
								+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, getT_u_id());
				psmt.setString(2, house.getName());
				psmt.setInt(3, house.getRenttype());			
				psmt.setString(4, house.getAddress());
				psmt.setFloat(5, house.getDayprice());
				psmt.setInt(6, house.getBill());
				psmt.setInt(7, house.getKind());
				psmt.setInt(8, house.getGuestnum());
				psmt.setInt(9, house.getBednum());
				psmt.setInt(10, house.getBedroomnum());
				psmt.setInt(11, house.getRoomnum());
				psmt.setString(12, house.getBedtype());
				psmt.setInt(13, house.getToiletnum());
				psmt.setString(14, house.getRoomdesc());
				psmt.setString(15, house.getUserule());
				psmt.setString(16, house.getCheckinTime());
				psmt.setString(17, house.getCheckoutTime());
				psmt.setInt(18, house.getMinday());
				psmt.setInt(19, house.getMaxday());
				psmt.setInt(20, house.getRefundday());
				psmt.setString(21, house.getPayrule());
				psmt.setString(22, house.getPicture1());
				psmt.setString(23, house.getShotcut1());
				psmt.setString(24, house.getPicture2());
				psmt.setString(25, house.getShotcut2());
				psmt.setString(26, house.getPicture3());
				psmt.setString(27, house.getShotcut3());
				psmt.setString(28, house.getFacility());
				psmt.setFloat(29, house.getArea());
				psmt.setInt(30, Constant.HOUSE_UNCHECKED);
				psmt.setInt(31, Constant.NOT_DELETED);
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
		} else {
			System.out.println("你创建的房屋名称已存在！");
		}
		return flag;
	}


	@Override
	public List<House> findByUserId(int userId) throws AppException {		
		PreparedStatement psmt = null;
		List<House> houseList = new ArrayList<House>();			
		try {
			conn = DBUtil.getConnection();
			sql = "select * from t_house where t_u_id = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				House house = new House();
				house.setId(rs.getInt("id"));
				house.setT_u_id(rs.getInt("t_u_id"));
				house.setName(rs.getString("name"));
				house.setRenttype(rs.getInt("renttype"));
				house.setAddress(rs.getString("address"));
				house.setDayprice(rs.getInt("dayprice"));
				house.setBill(rs.getInt("bill"));
				house.setKind(rs.getInt("kind"));
				house.setGuestnum(rs.getInt("guestnum"));
				house.setBednum(rs.getInt("bednum"));
				house.setBedroomnum(rs.getInt("bedroomnum"));
				house.setRoomnum(rs.getInt("roomnum"));
				house.setBedtype(rs.getString("bedtype"));
				house.setToiletnum(rs.getInt("toiletnum"));
				house.setRoomdesc(rs.getString("roomdesc"));
				house.setUserule(rs.getString("userule"));
				house.setCheckinTime(rs.getString("checkinTime"));
				house.setCheckoutTime(rs.getString("checkoutTime"));
				house.setMinday(rs.getInt("minday"));
				house.setMaxday(rs.getInt("maxday"));
				house.setRefundday(rs.getInt("refundday"));
				house.setPayrule(rs.getString("payrule"));
				house.setPicture1(rs.getString("picture1"));
				house.setPicture2(rs.getString("picture2"));
				house.setPicture3(rs.getString("picture3"));
				house.setShotcut1(rs.getString("shotcut1"));
				house.setShotcut2(rs.getString("shotcut2"));
				house.setShotcut3(rs.getString("shotcut3"));
				house.setFacility(rs.getString("facility"));
				house.setArea(rs.getInt("area"));
				house.setState(rs.getInt("state"));	
				house.setCreatetime(rs.getString("createtime"));
				houseList.add(house);
			}			
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			DBUtil.closeConnen(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return houseList;
	}

	@Override
	public List<House> findByState(int userId, int state) throws AppException {			
		PreparedStatement psmt = null;
		List<House> houseList = new ArrayList<House>();			
		try {
			conn = DBUtil.getConnection();
			sql = "select * from t_house where t_u_id = ? and state = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, userId);
			psmt.setInt(2, state);
			rs = psmt.executeQuery();
			while (rs.next()) {
				House house = new House();
				house.setId(rs.getInt("id"));
				house.setT_u_id(rs.getInt("t_u_id"));
				house.setName(rs.getString("name"));
				house.setRenttype(rs.getInt("renttype"));
				house.setAddress(rs.getString("address"));
				house.setDayprice(rs.getInt("dayprice"));
				house.setBill(rs.getInt("bill"));
				house.setKind(rs.getInt("kind"));
				house.setGuestnum(rs.getInt("guestnum"));
				house.setBednum(rs.getInt("bednum"));
				house.setBedroomnum(rs.getInt("bedroomnum"));
				house.setRoomnum(rs.getInt("roomnum"));
				house.setBedtype(rs.getString("bedtype"));
				house.setToiletnum(rs.getInt("toiletnum"));
				house.setRoomdesc(rs.getString("roomdesc"));
				house.setUserule(rs.getString("userule"));
				house.setCheckinTime(rs.getString("checkinTime"));
				house.setCheckoutTime(rs.getString("checkoutTime"));
				house.setMinday(rs.getInt("minday"));
				house.setMaxday(rs.getInt("maxday"));
				house.setRefundday(rs.getInt("refundday"));
				house.setPayrule(rs.getString("payrule"));
				house.setPicture1(rs.getString("picture1"));
				house.setPicture2(rs.getString("picture2"));
				house.setPicture3(rs.getString("picture3"));
				house.setShotcut1(rs.getString("shotcut1"));
				house.setShotcut2(rs.getString("shotcut2"));
				house.setShotcut3(rs.getString("shotcut3"));
				house.setFacility(rs.getString("facility"));
				house.setArea(rs.getInt("area"));
				house.setState(rs.getInt("state"));	
				house.setCreatetime(rs.getString("createtime"));
				houseList.add(house);
			}			
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			DBUtil.closeConnen(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}		
		return houseList;
	}

	@Override
	public int updateState(int setState, int houseId) throws AppException {
		int num = 0;
		PreparedStatement psmt = null;
		sql = "update t_house set state = ? where id = ?";		
		try {
			conn = DBUtil.getConnection();
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, setState);
			psmt.setInt(2, houseId);
			num=psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return num;
	}

	@Override
	public List<House> findByName(String searchName) throws AppException {
		List<House> houseList = new ArrayList<House>();	
		PreparedStatement psmt = null;
		sql = "select id, name, t_u_id, shotcut1, kind, renttype,"
				+ "area, dayprice, state, guestnum, address from t_house "
				+ "where (address like ? or name like ?) and state = ? and del = ?";
		try {
			conn = DBUtil.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+ searchName +"%");
			psmt.setString(2, "%"+ searchName +"%");
			psmt.setInt(3, Constant.HOUSE_PUBLISHED);
			psmt.setInt(4, Constant.NOT_DELETED);
			rs = psmt.executeQuery();
			while (rs.next()) {
				House house = new House();
				house.setId(rs.getInt("id"));
				house.setT_u_id(rs.getInt("t_u_id"));
				house.setName(rs.getString("name"));
				house.setShotcut1(rs.getString("shotcut1"));
				house.setKind(rs.getInt("kind"));
				house.setRenttype(rs.getInt("renttype"));
				house.setArea(rs.getInt("area"));
				house.setDayprice(rs.getInt("dayprice"));
				house.setState(rs.getInt("state"));
				house.setGuestnum(rs.getInt("guestnum"));
				house.setAddress(rs.getString("address"));
				houseList.add(house);								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnen(rs);
			DBUtil.closePreparedStatement(psmt);
			DBUtil.closeConnection(conn);
		}			
		return houseList;
	}

	@Override
	public List<HouseBusiModel> findById(int id, int state) throws AppException {
		PreparedStatement psmt = null;
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		try {
			conn = DBUtil.getConnection();	
			sql = "select * from t_house h left join t_user u on h.t_u_id = u.id where h.id = ? and h.state = ?";	
			psmt= conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setInt(2, state);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HouseBusiModel houseBusi = new HouseBusiModel();
				houseBusi.setUname(rs.getString("u.name"));
				houseBusi.setPassword(rs.getString("u.password"));
				houseBusi.setSex(rs.getInt("u.sex"));
				houseBusi.setMobile(rs.getString("u.mobile"));
				houseBusi.setEmail(rs.getString("u.email"));			
				houseBusi.setUaddress(rs.getString("u.address"));
				houseBusi.setPicture(rs.getString("u.picture"));
				houseBusi.setUdel(rs.getInt("u.del"));
				houseBusi.setId(rs.getInt("h.id"));
				houseBusi.setT_u_id(rs.getInt("h.t_u_id"));
				houseBusi.setName(rs.getString("h.name"));
				houseBusi.setRenttype(rs.getInt("h.renttype"));
				houseBusi.setAddress(rs.getString("h.address"));
				houseBusi.setDayprice(rs.getInt("h.dayprice"));
				houseBusi.setBill(rs.getInt("h.bill"));
				houseBusi.setKind(rs.getInt("h.kind"));
				houseBusi.setGuestnum(rs.getInt("h.guestnum"));
				houseBusi.setBednum(rs.getInt("h.bednum"));
				houseBusi.setBedroomnum(rs.getInt("h.bedroomnum"));
				houseBusi.setRoomnum(rs.getInt("h.roomnum"));
				houseBusi.setBedtype(rs.getString("h.bedtype"));
				houseBusi.setToiletnum(rs.getInt("h.toiletnum"));
				houseBusi.setRoomdesc(rs.getString("h.roomdesc"));
				houseBusi.setUserule(rs.getString("h.userule"));
				houseBusi.setCheckinTime(rs.getString("h.checkinTime"));
				houseBusi.setCheckoutTime(rs.getString("h.checkoutTime"));
				houseBusi.setMinday(rs.getInt("h.minday"));
				houseBusi.setMaxday(rs.getInt("h.maxday"));
				houseBusi.setRefundday(rs.getInt("h.refundday"));
				houseBusi.setPayrule(rs.getString("h.payrule"));
				houseBusi.setPicture1(rs.getString("h.picture1"));
				houseBusi.setPicture2(rs.getString("h.picture2"));
				houseBusi.setPicture3(rs.getString("h.picture3"));
				houseBusi.setShotcut1(rs.getString("h.shotcut1"));
				houseBusi.setShotcut2(rs.getString("h.shotcut2"));
				houseBusi.setShotcut3(rs.getString("h.shotcut3"));
				houseBusi.setFacility(rs.getString("h.facility"));
				houseBusi.setArea(rs.getInt("h.area"));
				houseBusi.setState(rs.getInt("h.state"));	
				houseBusi.setCreatetime(rs.getString("h.createtime"));								
				houseBusiList.add(houseBusi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return houseBusiList;
	}

	@Override
	public List<HouseBusiModel> getByState(int state) throws AppException {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		PreparedStatement psmt = null;
		conn = DBUtil.getConnection();
		sql = "select * from t_house h, t_user u where h.t_u_id = u.id and h.state = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);
			rs = psmt.executeQuery();
			while (rs.next()) {
				HouseBusiModel houseBusi = new HouseBusiModel();
				houseBusi.setUname(rs.getString("u.name"));
				houseBusi.setPassword(rs.getString("u.password"));
				houseBusi.setSex(rs.getInt("u.sex"));
				houseBusi.setMobile(rs.getString("u.mobile"));
				houseBusi.setEmail(rs.getString("u.email"));			
				houseBusi.setUaddress(rs.getString("u.address"));
				houseBusi.setPicture(rs.getString("u.picture"));
				houseBusi.setUdel(rs.getInt("u.del"));
				houseBusi.setId(rs.getInt("h.id"));
				houseBusi.setT_u_id(rs.getInt("h.t_u_id"));
				houseBusi.setName(rs.getString("h.name"));
				houseBusi.setRenttype(rs.getInt("h.renttype"));
				houseBusi.setAddress(rs.getString("h.address"));
				houseBusi.setDayprice(rs.getInt("h.dayprice"));
				houseBusi.setBill(rs.getInt("h.bill"));
				houseBusi.setKind(rs.getInt("h.kind"));
				houseBusi.setGuestnum(rs.getInt("h.guestnum"));
				houseBusi.setBednum(rs.getInt("h.bednum"));
				houseBusi.setBedroomnum(rs.getInt("h.bedroomnum"));
				houseBusi.setRoomnum(rs.getInt("h.roomnum"));
				houseBusi.setBedtype(rs.getString("h.bedtype"));
				houseBusi.setToiletnum(rs.getInt("h.toiletnum"));
				houseBusi.setRoomdesc(rs.getString("h.roomdesc"));
				houseBusi.setUserule(rs.getString("h.userule"));
				houseBusi.setCheckinTime(rs.getString("h.checkinTime"));
				houseBusi.setCheckoutTime(rs.getString("h.checkoutTime"));
				houseBusi.setMinday(rs.getInt("h.minday"));
				houseBusi.setMaxday(rs.getInt("h.maxday"));
				houseBusi.setRefundday(rs.getInt("h.refundday"));
				houseBusi.setPayrule(rs.getString("h.payrule"));
				houseBusi.setPicture1(rs.getString("h.picture1"));
				houseBusi.setPicture2(rs.getString("h.picture2"));
				houseBusi.setPicture3(rs.getString("h.picture3"));
				houseBusi.setShotcut1(rs.getString("h.shotcut1"));
				houseBusi.setShotcut2(rs.getString("h.shotcut2"));
				houseBusi.setShotcut3(rs.getString("h.shotcut3"));
				houseBusi.setFacility(rs.getString("h.facility"));
				houseBusi.setArea(rs.getInt("h.area"));
				houseBusi.setState(rs.getInt("h.state"));	
				houseBusi.setCreatetime(rs.getString("h.createtime"));								
				houseBusiList.add(houseBusi);			
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return houseBusiList;
	}

}
