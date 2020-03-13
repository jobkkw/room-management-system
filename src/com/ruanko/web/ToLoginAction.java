package com.ruanko.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class ToLoginAction {
	
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();			
		String message = (String) request.getAttribute("message");
		request.setAttribute("messages", message);
		String name = (String) request.getAttribute("name");
		request.setAttribute("name", name);
		String pass = (String) request.getAttribute("pass");
		request.setAttribute("pass", pass);
		return "login";
	}
}
