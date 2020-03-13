package com.ruanko.model;

public class Constant {

	//房屋状态
	public static final int HOUSE_UNCHECKED = 1;//待审核
	public static final int HOUSE_UNPUBLISHED = 2;//审核待发布
	public static final int HOUSE_PUBLISHED = 3;//已发布
	public static final int HOUSE_REFUSED = 4;//审核拒绝
	//删除状态
	public static final int NOT_DELETED = 0;//未删除
	public static final int DELETED = 1;//已删除
	//房屋出租状态
	public static final int HOUSE_RENTED = 1;//已出租 
	public static final int HOUSE_NOT_RENTED = 2;//未出租
	//房屋租住天数的最大值
	public static final int RENT_MAX_DAY = 30;
	//订单状态
	public static final int ORDER_UNCHECKED = 1;//待受理
	public static final int ORDER_ABOLISHED = 2;//已取消
	public static final int ORDER_PASSED = 3;//已受理
	public static final int ORDER_UNSUBSCRIBE = 4;//退订
	public static final int ORDER_REFUSED = 5;//已拒绝
	//评论状态
	public static final int COMMENTED = 1;//已评论
	public static final int NOT_COMMENTED = 2;//未评论
	
}
