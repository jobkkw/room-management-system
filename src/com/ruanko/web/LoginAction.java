package com.ruanko.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruanko.model.User;
import com.ruanko.service.UserService;

public class LoginAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	User users = new User();
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	    
		UserService userService = new UserService();
	
		request.setAttribute("name", users.getName());
		request.setAttribute("pass", users.getPassword());
		if (users.getName()==null ||  users.getPassword()==null || users.getName().equals("") ||  users.getPassword().equals("")) {			
			request.setAttribute("message", "用户名或密码不能为空！");
			return "fail";
		} else {
			User user = userService.login(users.getName(), users.getPassword());
			try {																		    
					session.setAttribute("user", user);		
					return "success";				
			} catch (Exception e) {
				return "error";			
			}
		}
					
	}

	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return users;
	}
	
	
}
