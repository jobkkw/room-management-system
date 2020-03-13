package com.ruanko.service;

import java.util.ArrayList;
import java.util.List;

import com.ruanko.dao.impl.HouseDaoImpl;
import com.ruanko.daos.HouseDao;
import com.ruanko.model.Constant;
import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.util.AppException;

public class HouseService {

	HouseDao houseDao = new HouseDaoImpl();	
		
	//用户创建房屋
	public boolean createHouse (House house) {	
		boolean flag = false;
		try {
			flag = houseDao.save(house);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return flag;
	}
	
	//通过用户id获取输入的房屋信息
	public List<House> getMyHouse (int userId) {
		List<House> houseList = new ArrayList<House>();
		try {
			houseList = houseDao.findByUserId(userId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return houseList;
	} 
	
	//通过用户id和state（房屋状态）获取输入的房屋信息
	public List<House> getUnpublishedHouse (int userId, int state) {
		List<House> houseList = new ArrayList<House>();
		try {
			houseList = houseDao.findByState(userId, state);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return houseList;
	}
	
	//通过用户id修改房屋的状态为已发布
	public int publishHouse (int houseId) {
		int num = 0;
		try {
			num = houseDao.updateState(Constant.HOUSE_PUBLISHED, houseId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return num;
	}
		
	//通过用户id修改房屋的状态为审核待发布
	public int checkHouse (int houseId) {
		int num = 0;
		try {
			num = houseDao.updateState(Constant.HOUSE_UNPUBLISHED, houseId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return num;
	}
	
	//通过用户id修改房屋的状态为审核拒绝
	public int refuseHouse (int houseId) {
		int num = 0;
		try {
			num = houseDao.updateState(Constant.HOUSE_REFUSED, houseId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return num;
	}
	
	//通过房屋名称和房屋地址查询房屋信息
	public List<House> findByName (String searchName){
		List<House> houseList = new ArrayList<House>();
		try {			
			houseList = houseDao.findByName(searchName);
		} catch (AppException e) {
			e.printStackTrace();
		}			
		return houseList;
	} 	
		
	//根据房屋id和房屋状态，级联查询房屋和用户信息
	public List<HouseBusiModel> findById (int id , int state) {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		try {
			houseBusiList = houseDao.findById(id, state);
		} catch (AppException e) {
			e.printStackTrace();
		}
		return houseBusiList;	
	}
	
	//根据状态获取待审核的房屋
	public List<HouseBusiModel> getUncheckedHouse () throws AppException {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();					
		houseBusiList = houseDao.getByState(Constant.HOUSE_UNCHECKED);
		return houseBusiList;
	}
	
	
}
