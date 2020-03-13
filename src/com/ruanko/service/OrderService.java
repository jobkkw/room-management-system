package com.ruanko.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;

import com.ruanko.dao.impl.DealOrderDaoImpl;
import com.ruanko.dao.impl.OrderDaoImpl;
import com.ruanko.dao.impl.RentLockDaoImpl;
import com.ruanko.daos.DealOrderDao;
import com.ruanko.daos.OrderDao;
import com.ruanko.daos.RentLockDao;
import com.ruanko.model.Constant;
import com.ruanko.model.Order;
import com.ruanko.model.OrderBusiModel;
import com.ruanko.model.RentLock;
import com.ruanko.util.AppException;

public class OrderService {
	
	RentLockDao rentLockDao = new RentLockDaoImpl();	
	OrderDao orderDao = new OrderDaoImpl();
	DealOrderDao dealOrderDao = new DealOrderDaoImpl();
	boolean flag = false;
		
	//退订订单
	public boolean unsubscribeOrder (int orderid) {
		flag = rentLockDao.unsubscribeOrder(Constant.ORDER_UNSUBSCRIBE, orderid, Constant.ORDER_PASSED);
		return flag;
	}
	
	
	//取消订单
	public boolean abolishOrder (int orderid) {
		flag = rentLockDao.abolishOrder(Constant.ORDER_ABOLISHED, orderid, Constant.ORDER_UNCHECKED);		
		return flag;
	}
	
		
	//拒绝订单，并改变订单状态
	public boolean refuseOrder (int orderid, int state) {
		//将订单状态改为已拒绝
		flag = orderDao.updateState(Constant.ORDER_REFUSED, orderid, state);
		return flag;
	}
	
	
	//受理订单，并保存订单信息
	public boolean checkOrder (int orderid, int state) {
		//将订单状态改为已受理
		flag = orderDao.updateState(Constant.ORDER_PASSED, orderid, state);
		 
		//查询订单信息
		Order order = orderDao.getOrderById(orderid);
		
		//更改与此订单冲突的订单状态为已拒绝
		orderDao.updateConflictOrderByState(order, Constant.ORDER_UNCHECKED);
		
		//保存房屋出租状态
		long checkindate = order.getCheckindate().getTime();
		long checkoutdate = order.getCheckoutdate().getTime();
		while (checkindate < checkoutdate) {
			RentLock rentLock = new RentLock();
			rentLock.setRentdate(new java.sql.Date(checkindate));
			rentLock.setT_h_id(order.getT_h_id());
			rentLock.setState(Constant.HOUSE_RENTED);
			rentLockDao.save(rentLock);
			checkindate += 1000 * 60 * 60 * 24;
		}
		
		//保存预定记录
		dealOrderDao.save(order);
		
		return flag;
	}
	
	
	//查询待受理订单
	public List<OrderBusiModel> getHostUncheckedOrder (int userid) {
		List<OrderBusiModel> orderBusilist = new ArrayList<OrderBusiModel>();
		orderBusilist = rentLockDao.getHostUncheckedOrder(userid, Constant.ORDER_UNCHECKED);		
		return orderBusilist;
	}
	
	
	//查询已受理订单
	public List<OrderBusiModel> getHostCheckedOrder (int userid) {
		List<OrderBusiModel> orderBusilist = new ArrayList<OrderBusiModel>();
		orderBusilist = rentLockDao.getHostCheckedOrder(userid, Constant.ORDER_PASSED);		
		return orderBusilist;
	}
	
	//保存订单信息
	public boolean book (Order order) throws AppException {
		int rentdays = order.getRentDays();
		if (rentdays <= 0 || rentdays > Constant.RENT_MAX_DAY) {
			return flag;
		}
		if (rentLockDao.getRentLock(order, Constant.HOUSE_RENTED).size() == 0) {
			order.setOrdernum(generateOrdernum());
			float total = order.getUnitprice() * rentdays; 
			order.setTotal(total);
			order.setState(Constant.ORDER_UNCHECKED);//订单状态设置为待受理			
		}
		if (rentLockDao.save(order)) {
			flag = true;
		}
		return flag;
	}
	
	
	//生成订单号
	private String generateOrdernum () {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		Random random = new Random();
		String account = simpleDateFormat.format(date) + random.nextInt(999999);
		return account;		
	}
	
	
}
