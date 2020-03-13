package com.ruanko.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ruanko.util.AppException;

public class LogoutAction {
	
	public String execute() throws AppException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();	    
		session.removeAttribute("user");
		return "success";
	}
	
	
}
