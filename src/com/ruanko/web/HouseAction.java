package com.ruanko.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.service.HouseService;
import com.ruanko.util.AppException;

public class HouseAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();	
	HouseService houseService = new HouseService();
	
	//通过房屋名称和房屋地址查询房屋信息
	public String search () {		
		String searchName = request.getParameter("searchName");		
		if (searchName == null) {
			searchName = "";
		}
		List<House> houseList = new ArrayList<House>();	
		houseList = houseService.findByName(searchName);
		request.setAttribute("houseList", houseList);
		request.setAttribute("searchName", searchName);
		return "search_succ";
	}
	
	//根据房屋id和房屋状态，级联查询房屋和用户信息
	public String getHouseById () {
		int id = Integer.parseInt((String) request.getParameter("id"));	
		int state = Integer.parseInt((String) request.getParameter("state"));	
		if (id != 0 && state == 3) {
			List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
			houseBusiList = houseService.findById(id, state);
			request.setAttribute("houseBusiList", houseBusiList);
			return "getHouseById_succ";
		} else {
			return "getHouseById_fail";
		}
					
	} 
	
	//根据状态获取待审核的房屋
	public String toUnchecked () {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		try {
			houseBusiList = houseService.getUncheckedHouse();
		} catch (AppException e) {			
			e.printStackTrace();
		}
		request.setAttribute("houseBusiList", houseBusiList);		
		return "toUnchecked_succ";
	}
	
	//通过用户id修改房屋的状态为审核待发布
	public String check () {
		String houseId = request.getParameter("houseId");
		houseService.checkHouse(Integer.parseInt(houseId));	
		return "check_succ";
	}
		
	//通过用户id修改房屋的状态为审核拒绝
	public String refuse () {
		String houseId = request.getParameter("houseId");
		houseService.refuseHouse(Integer.parseInt(houseId));	
		return "refuse_succ";	
	}
	
}
