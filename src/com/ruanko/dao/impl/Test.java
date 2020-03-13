package com.ruanko.dao.impl;

import com.ruanko.model.Constant;
import com.ruanko.model.Order;

public class Test {

	public static void main(String[] args) {
		
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		Order order = orderDaoImpl.getOrderById(6);
		System.out.print(order.getOrderdate());
		orderDaoImpl.updateConflictOrderByState(order, Constant.ORDER_UNCHECKED);
		
		
		
	}

}
