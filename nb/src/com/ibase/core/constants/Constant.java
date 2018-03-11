package com.ibase.core.constants;

public interface Constant {
	
	//登录用户
	public static final String SESSION_USER = "session_user";
	
	//车库状态   1：启用   2:停用
	public static final Integer PARKING_LOT_ENABLE = 1;
	public static final Integer PARKING_LOT_UNABLE = 2;
	
	//车位状态 1:空闲 2:已用 3:已预约  0:不可用
	public static final Integer PARKING_POSITION_UNUSED = 0;
	public static final Integer PARKING_POSITION_USED = 1;
	public static final Integer PARKING_POSITION_BOOK = 2;
	public static final Integer PARKING_POSITION_UNABLE = 3;
	
	//订单状态  1:未支付  2：已支付
	public static final Integer NOT_PAID = 1;
	public static final Integer PAID = 2;
}
