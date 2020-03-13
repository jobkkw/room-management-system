package com.ruanko.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerLogoutAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();	  
	
	@Override
	public String execute() throws Exception {
		session.removeAttribute("manager");
		return SUCCESS;
	}
	
}
