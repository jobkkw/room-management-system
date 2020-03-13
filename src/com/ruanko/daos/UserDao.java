package com.ruanko.daos;

import com.ruanko.model.User;
import com.ruanko.util.AppException;

public interface UserDao {
	
	//判断用户名是否已经存在
	public boolean isExist(String name) throws AppException;
	//保存用户输入的信息
	public boolean save(User user) throws AppException;
	//根据用户名、密码查询用户编号
	public int login(String name, String password) throws AppException;
	//查询是否有匹配的用户，有则返回用户信息User类对象
	public User getUser (int id) throws AppException;
	
	
}
