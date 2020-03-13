package com.ruanko.daos;

import com.ruanko.model.Order;

public interface OrderDao {

	//更新订单状态
	public boolean updateState (int setState,int orderid, int state);
	
	//获得订单信息
	public Order getOrderById (int orderid);
	
	//改变冲突订单状态
	public boolean updateConflictOrderByState (Order order, int state);
	
	
}
