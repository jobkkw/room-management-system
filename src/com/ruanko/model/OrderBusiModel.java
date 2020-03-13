package com.ruanko.model;

import java.sql.Date;

public class OrderBusiModel {

	private int id;
	private int t_u_id;
	private int t_h_id;
	private String ordernum;
	private Date checkindate;	
	private Date checkoutdate;
	private int state;
	private float unitprice;
	private String orderdate;
	private int commentstate;
	private float total;
	private int del;
	
	private String shotcut1;
	private String housename;
	private String username;
	private int userid;
		
	private String checktime;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getT_u_id() {
		return t_u_id;
	}

	public void setT_u_id(int t_u_id) {
		this.t_u_id = t_u_id;
	}

	public int getT_h_id() {
		return t_h_id;
	}

	public void setT_h_id(int t_h_id) {
		this.t_h_id = t_h_id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public Date getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}

	public Date getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getCommentstate() {
		return commentstate;
	}

	public void setCommentstate(int commentstate) {
		this.commentstate = commentstate;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getShotcut1() {
		return shotcut1;
	}

	public void setShotcut1(String shotcut1) {
		this.shotcut1 = shotcut1;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChecktime() {
		return checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	
	
}
