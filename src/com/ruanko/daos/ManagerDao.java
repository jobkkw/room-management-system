package com.ruanko.daos;

import com.ruanko.model.Manager;

public interface ManagerDao {
	

	//根据用户名、密码查询管理员编号
	public int login (String name, String password);
		
	//查询是否有匹配的管理员，有则返回管理员信息
	public Manager getManager (int id);
	
}
