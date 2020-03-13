package com.ruanko.model;

public class House {
	
	private int id;
	private int t_u_id;
	private String name;
	private int bill; 
	private int renttype;
	private int kind;
	private float area;
	private int guestnum;
	private int bednum;
	private int bedroomnum;
	private int roomnum;
	private String bedtype;
	private int toiletnum;
	private String roomdesc;
	private String userule;
	private String facility;
	private String address;
	private String picture1;
	private String shotcut1;
	private String picture2;
	private String shotcut2;
	private String picture3;
	private String shotcut3;
	private String checkinTime;
	private String checkoutTime;
	private int minday;
	private int maxday;
	private int refundday;
	private String payrule; 
	private float dayprice; 
	private String createtime;
	private int state;
	private int del;
	
	public House () {
		this.id = 0;
		this.t_u_id = 0;
		this.name = "";
		this.bill = 0; 
		this.renttype = 0;
		this.kind = 0;
		this.area = 0.0f;
		this.guestnum = 0;
		this.bednum = 0;
		this.bedroomnum = 0;
		this.roomnum = 0;
		this.bedtype = "";
		this.toiletnum = 0;
		this.roomdesc = "";
		this.userule = "";
		this.facility = "";
		this.address = "";
		this.picture1 = "";
		this.shotcut1 = "";
		this.picture2 = "";
		this.shotcut2 = "";
		this.picture3 = "";
		this.shotcut3 = "";
		this.checkinTime = "";
		this.checkoutTime = "";
		this.minday = 0;
		this.maxday = 0;
		this.refundday = 0;
		this.payrule = ""; 
		this.dayprice = 0.0f; 
		this.createtime = "";
		this.state = 0;
		this.del = 0;		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public int getRenttype() {
		return renttype;
	}

	public void setRenttype(int renttype) {
		this.renttype = renttype;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public float getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public int getGuestnum() {
		return guestnum;
	}

	public void setGuestnum(int guestnum) {
		this.guestnum = guestnum;
	}

	public int getBednum() {
		return bednum;
	}

	public void setBednum(int bednum) {
		this.bednum = bednum;
	}

	public int getBedroomnum() {
		return bedroomnum;
	}

	public void setBedroomnum(int bedroomnum) {
		this.bedroomnum = bedroomnum;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public int getToiletnum() {
		return toiletnum;
	}

	public void setToiletnum(int toiletnum) {
		this.toiletnum = toiletnum;
	}

	public String getRoomdesc() {
		return roomdesc;
	}

	public void setRoomdesc(String roomdesc) {
		this.roomdesc = roomdesc;
	}

	public String getUserule() {
		return userule;
	}

	public void setUserule(String userule) {
		this.userule = userule;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getShotcut1() {
		return shotcut1;
	}

	public void setShotcut1(String shotcut1) {
		this.shotcut1 = shotcut1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getShotcut2() {
		return shotcut2;
	}

	public void setShotcut2(String shotcut2) {
		this.shotcut2 = shotcut2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getShotcut3() {
		return shotcut3;
	}

	public void setShotcut3(String shotcut3) {
		this.shotcut3 = shotcut3;
	}

	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public int getMinday() {
		return minday;
	}

	public void setMinday(Integer minday) {
		this.minday = minday;
	}

	public int getMaxday() {
		return maxday;
	}

	public void setMaxday(Integer maxday) {
		this.maxday = maxday;
	}

	public int getRefundday() {
		return refundday;
	}

	public void setRefundday(Integer refundday) {
		this.refundday = refundday;
	}

	public String getPayrule() {
		return payrule;
	}

	public void setPayrule(String payrule) {
		this.payrule = payrule;
	}

	public float getDayprice() {
		return dayprice;
	}

	public void setDayprice(Integer dayprice) {
		this.dayprice = dayprice;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
