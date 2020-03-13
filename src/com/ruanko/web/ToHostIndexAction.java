package com.ruanko.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ruanko.model.User;

public class ToHostIndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String execute() throws Exception {			
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		ActionContext request = ActionContext.getContext();  
//	    Map<String, Object> session = request.getSession(); 
//	    User user = (User) session.get("user");			
		if (user == null || user.getName() == null || user.getName().equals("")) {
			request.setAttribute("message", "用户名或密码错误！");
			session.removeAttribute("user");
			String name = (String) request.getAttribute("name");
			request.setAttribute("name", name);
			String pass = (String) request.getAttribute("pass");
			request.setAttribute("pass", pass);	
			return "login";
		} else {			
			return "hostindex";
		}
				
	}		
	
}
