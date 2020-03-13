package com.ruanko.model;

public class DealOrder {
	
	private int id;
	private int t_u_id;
	private int t_h_id;
	private String ordernum;
	private String checkindate;
	private String checkoutdate;
	private float unitprice;
	private String orderdate;
	private String checktime;
	private float total;
	private int state;
	private int commentstate;
	private int del;
	
	public DealOrder () {
		this.id = 0;
		this.t_h_id = 0;
		this.t_u_id = 0;
		this.orderdate = "";
		this.ordernum = "";
		this.checkindate = "";
		this.checkoutdate = "";
		this.commentstate = 0;
		this.checktime = "";
		this.total = 0;
		this.del = 0;
		this.unitprice = 0;
		this.state = 0;
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

	public String getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}

	public String getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
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

	public String getChecktime() {
		return checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCommentstate() {
		return commentstate;
	}

	public void setCommentstate(int commentstate) {
		this.commentstate = commentstate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

		
}
