package com.ruanko.model;

import java.sql.Date;

public class Order {
	
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
	
	//计算租住天数
	public int getRentDays () {
		int daysBetween = 0;
		long begin = checkindate.getTime(); 
		long end = checkoutdate.getTime();
		daysBetween = (int) ((end - begin) / (60 * 60 * 24 * 1000));
		return daysBetween;
	}
	
	public Order () {
		this.id = 0;
		this.t_h_id = 0;
		this.t_u_id = 0;
		this.ordernum = "";
		this.state = 0;
		this.unitprice = 0;
		this.orderdate = "";
		this.commentstate = 0;
		this.total = 0;
		this.del = 0;		
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

	
}
