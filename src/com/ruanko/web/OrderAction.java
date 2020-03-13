package com.ruanko.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.model.Order;
import com.ruanko.model.OrderBusiModel;
import com.ruanko.model.User;
import com.ruanko.service.HouseService;
import com.ruanko.service.OrderService;
import com.ruanko.util.AppException;

public class OrderAction extends ActionSupport implements ModelDriven<Object>{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();	
	HouseService houseService = new HouseService();
	OrderService orderService = new OrderService();
	Order order = new Order();
	List<OrderBusiModel> orderBusilist = new ArrayList<OrderBusiModel>();	
	String message = "";

	
	public List<OrderBusiModel> getOrderBusilist() {
		return orderBusilist;
	}

	public void setOrderBusilist(List<OrderBusiModel> orderBusilist) {
		this.orderBusilist = orderBusilist;
	}
 
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//房客退订已受理订单
	public String myUnsubscribed () {
		String orderid = request.getParameter("orderid");
		orderService.unsubscribeOrder(Integer.parseInt(orderid));
		return "myUnsubscribed_succ";
	}
	
	
	//房客取消待受理订单
	public String myAbolished () {
		String orderid = request.getParameter("orderid");
		orderService.abolishOrder(Integer.parseInt(orderid));
		return "myAbolished_succ";
	}
	
	
	//房客查看已受理订单
	public String myChecked () {
		User user = (User) session.getAttribute("user");		
		orderBusilist = orderService.getHostCheckedOrder(user.getId());
		request.setAttribute("orderBusilist", orderBusilist);						
		return "myChecked_succ";
	}
	
		
	//房客查看待受理订单
	public String myUnChecked () {
		User user = (User) session.getAttribute("user");		
		orderBusilist = orderService.getHostUncheckedOrder(user.getId());
		request.setAttribute("orderBusilist", orderBusilist);						
		return "myUnChecked_succ";
	}
	
	
	//拒绝订单，并改变订单状态
	public String refuse () {
		String orderid = request.getParameter("orderid");
		String state = request.getParameter("state");
		orderService.refuseOrder(Integer.parseInt(orderid), Integer.parseInt(state));		
		return "refuse_succ";
	}
	
	
	//受理订单，并保存订单信息
	public String check () {
		String orderid = request.getParameter("orderid");
		String state = request.getParameter("state");
		orderService.checkOrder(Integer.parseInt(orderid), Integer.parseInt(state));		
		
		return "check_succ";				
	}
	
	
	//查询待受理订单
	public String toUnchecked () {
		User user = (User) session.getAttribute("user");		
		orderBusilist = orderService.getHostUncheckedOrder(user.getId());
		request.setAttribute("orderBusilist", orderBusilist);		
		return "toUnchecked_succ";
	}
	
		
	//下订单
	public String book () throws AppException {
		String state = request.getParameter("state");
		User user = (User) session.getAttribute("user");
		if (user == null) {
			message = "你还未登录，请登录后重新预定！";			
		} else if (orderService.book(order)) {
			message = "预定成功！入住天数：" + order.getRentDays() + "天，总价格：" + order.getTotal() + "元"; 
		} else {
			message = "预定失败，请重新尝试！";
		}
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		houseBusiList = houseService.findById(order.getT_h_id(), Integer.parseInt(state));
		request.setAttribute("houseBusiList", houseBusiList);
		request.setAttribute("message", message);
		return "book_succ";
		
	}

	@Override
	public Object getModel() {
		return order;
	}
		
}
