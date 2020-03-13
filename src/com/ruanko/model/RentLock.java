package com.ruanko.model;

import java.sql.Date;

public class RentLock {

	private int id;
	private int t_h_id;
	private Date rentdate;
	private int state;
	private int del;
	
	public RentLock() {
		this.id = 0;
		this.t_h_id = 0;
		this.state = 0;
		this.del = 0;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getT_h_id() {
		return t_h_id;
	}

	public void setT_h_id(int t_h_id) {
		this.t_h_id = t_h_id;
	}

	public Date getRentdate() {
		return rentdate;
	}


	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}	
	
	
}
