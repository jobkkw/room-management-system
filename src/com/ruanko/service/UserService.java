package com.ruanko.service;

import com.ruanko.dao.impl.UserDaoImpl;
import com.ruanko.daos.UserDao;
import com.ruanko.model.User;
import com.ruanko.util.AppException;

public class UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	public boolean register (User user) throws AppException{
		boolean flag = false;		
		try {
			if (!userDao.isExist(user.getName())) {
				flag = userDao.save(user);
			}
		} catch (AppException e) {
			//throw new AppException("com.ruanko.service.UserService.register");	
			e.printStackTrace();
		}
		return flag;		
	}
	
	public User login (String name, String password) throws AppException{
		int id = 0;
		User user = new User();
		try {
			id = userDao.login(name, password);
			if (id > 0) {
				user = userDao.getUser(id); 
			}
		} catch (AppException e) {
			//throw new AppException("com.ruanko.service.UserService.login");			
			e.printStackTrace();
		}				
		return user;		
	}
	
	
	
}
