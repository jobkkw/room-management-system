package com.ruanko.daos;

import java.util.List;

import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.util.AppException;

public interface HouseDao {

	//保存用户输入的信息
	public boolean save(House house) throws AppException;
	
	//通过用户id获取输入的房屋信息
	public List<House> findByUserId (int userId) throws AppException; 	
	
	//通过用户id和state（房屋状态）获取输入的房屋信息
	public List<House> findByState (int userId, int state) throws AppException; 	
	
	//通过房屋id修改房屋的状态
	public int updateState (int setState, int houseId) throws AppException; 	
		
	//通过房屋名称和房屋地址查询房屋信息
	public List<House> findByName (String searchName) throws AppException; 	
		
	//根据房屋id和房屋状态，级联查询房屋和用户信息
	public List<HouseBusiModel> findById (int id , int state) throws AppException; 
		
	//根据状态获取待审核的房屋
	public List<HouseBusiModel> getByState (int state) throws AppException;
	
}
