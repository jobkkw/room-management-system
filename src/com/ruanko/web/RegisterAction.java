package com.ruanko.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruanko.model.User;
import com.ruanko.service.UserService;
import com.ruanko.util.AppException;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	User users = new User();
	
	@Override
	public String execute() throws AppException{				
		UserService userService = new UserService();
		boolean flag = false;
		try {
			if (users.getName() == null || users.getPassword() == null || users.getMobile() == null ||
				users.getName().equals("") || users.getPassword().equals("") || users.getMobile().equals("")) {
				return "fail";
			} else {
				flag = userService.register(users);
				if (flag) {
					return "success";
				} else {
					return "fail";
				}
			} 									
		} catch (AppException e) {			
			return "error";
		}			
	}
	
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return users;
	}
		
	
}
