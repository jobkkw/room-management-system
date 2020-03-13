package com.ruanko.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ruanko.dao.impl.HouseDaoImpl;
import com.ruanko.model.House;
import com.ruanko.model.User;
import com.ruanko.service.HouseService;

public class PublishHouseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<House> houseList;
	private House house;
	
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public List<House> getHouseList() {
		return houseList;
	}
	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");	
	HouseService houseService = new HouseService();
	HouseDaoImpl houseDao = new HouseDaoImpl();
	
	//处理“获取审核未发布房屋列表”请求
	public String toPublish () {
		houseList = houseService.getUnpublishedHouse(houseDao.getT_u_id(), 2);
		request.setAttribute("houseList", houseList);
		return SUCCESS;		
	}
	
	//处理“发布房屋”请求
	public String publish () {
		String houseId = request.getParameter("id");
		int num = houseService.publishHouse(Integer.parseInt(houseId));
		if (num == 0) {
			System.out.println("发布房屋失败！");
		}
		return SUCCESS;
	}
	
}
