package com.ruanko.daos;

import java.util.List;
import com.ruanko.model.Order;
import com.ruanko.model.OrderBusiModel;
import com.ruanko.model.RentLock;

public interface RentLockDao{
	
	//获取对应时间段内房屋出租状态记录
	public List<RentLock> getRentLock (Order order, int state);
	
	//保存订单信息
	public boolean save (Order order);
		
	//查询待受理订单
	public List<OrderBusiModel> getHostUncheckedOrder (int userid, int state);
	
	//保存房屋租住状态信息
	public boolean save (RentLock rentLock);
	
	//查询已受理订单
	public List<OrderBusiModel> getHostCheckedOrder (int userid, int state);
	
	//取消订单
	public boolean abolishOrder (int setState, int orderid, int state);
	
	//退订订单
	public boolean unsubscribeOrder (int setState, int orderid, int state);
	
}
